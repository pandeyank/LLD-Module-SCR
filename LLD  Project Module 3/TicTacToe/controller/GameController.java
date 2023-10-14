package controller;

import Exceptions.InvaliddimensionException;
import models.Game;
import models.GameStatus;
import models.Player;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class GameController {
    public void undo()
    {
    }
    public Game createGame(int dimension, List<Player> players){
        return Game.getbuilder().setDimension(dimension).setPlayers(players).build();

    }
    public Player getWinner(Game game)
    {
        return game.getWinner();
    }
    public void displayboard(Game game)
    {
        game.getBoard().displayBoard();
    }
    public GameStatus getGameStatus(Game game)
    {
        return game.getGameStatus();
    }
    public void executeNextMove(Game game)
    {

        game.nextMove();
    }
}
