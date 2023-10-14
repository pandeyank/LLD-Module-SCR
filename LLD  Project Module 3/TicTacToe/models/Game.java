package models;

import java.util.ArrayList;
import java.util.List;

import Exceptions.InvalidNumberOfPlayer;
import Exceptions.InvaliddimensionException;


public  class Game {
    private Board board;
    private List<Player> players;
    private List<Moves> moves;
    private GameStatus gameStatus;
    private int nextPlayerIndex;
    private Player winner;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Moves> getMoves() {
        return moves;
    }

    public void setMoves(List<Moves> moves) {
        this.moves = moves;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
    public static GameBuilder getbuilder()
    {
        return new GameBuilder();
    }

    public void nextMove() {
        //1: Get the next player to move
        //System.out.println("Hello Executed Line");
        Player curr_player=players.get(nextPlayerIndex);
        //System.out.println("Hello Not Executed Line");
        //2: Player should decide the move
        Moves moves1=curr_player.decideMove(this.board);
        //3: Validate the move
        int row=moves1.getCell().getRow();
        int col=moves1.getCell().getCol();

        //4: If move is valid then make the move:
        System.out.println("Move happend at (" +row +" , " +col+ " )"  );
        board.getBoard().get(row).get(col).setCellStatus(CellStatus.filled);
        board.getBoard().get(row).get(col).setPlayer(curr_player);

        //5: add moves in moves list:

        moves.add(moves1);

        //6: move to next player:

        nextPlayerIndex+=1;
        nextPlayerIndex%=players.size();

    }


    public static class GameBuilder {
        private int dimension;
        private List<Player> players;

        public int getDimension() {
            return dimension;
        }

        public GameBuilder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public  GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        private void isValid() throws InvaliddimensionException{
            if(this.dimension<3)
            {
                throw new InvaliddimensionException("Dimension can't be less than 3:");
            }
            /*if(players.size() == dimension-1){
                try {
                    throw new InvalidNumberOfPlayer("Player always be 1 less than dimension:");
                } catch (InvalidNumberOfPlayer e) {
                    throw new RuntimeException(e);
                }

            }*/



        }
        public Game build()
        {
            try {
                isValid();
            } catch (Exception e) {
                throw new RuntimeException("Exception ocuured in the Game class:");
            }
            Game game=new Game();
            game.setBoard(new Board(dimension));
            game.setGameStatus(GameStatus.InProgress);
            game.setPlayers(players);
            game.setMoves(new ArrayList<>());
            game.setNextPlayerIndex(0);
            return game;

        }
    }
}

