import controller.GameController;
import models.Game;
import models.GameStatus;
import models.Player;
import models.PlayerType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        GameController gameController=new GameController();
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the dimension of the game:");
        int dimension=scan.nextInt();

        System.out.println("Will be any Bot in the Game: y/n");
        String  bot=scan.next();

        int noOfHuman= dimension-1;
        List<Player> players=new ArrayList<>();
        if(bot.charAt(0)=='y')
        {
            noOfHuman-=1;
            System.out.println("Enter the name of Bot:");
            String botname=scan.next();
            System.out.println("Enter the symbol of the bot:");
            String symbol=scan.next();
            //players.add(new Player(name,symbol.charAt(0), PlayerType.Human))
        }
        for(int i=0;i<noOfHuman;i++)
        {
            System.out.println("Enter the Player name:");
            String name=scan.next();
            System.out.println("Enter the symbol of the player:");
            String symbol=scan.next();
            players.add(new Player(symbol.charAt(0),name,PlayerType.Human));
        }

        System.out.println("Yaha tak bana");
        Game game= gameController.createGame(dimension,players);

        while (gameController.getGameStatus(game).equals(GameStatus.InProgress))
        {
            System.out.println("This is the current Board:");
            gameController.displayboard(game);

            System.out.println("Do you want to undo: y/n");
            String undo=scan.next();
            if(undo.charAt(0)=='y')
            {
                gameController.undo();
            }
            else
            {
                gameController.executeNextMove(game);
            }
        }

        if(gameController.getGameStatus(game).equals(GameStatus.Ended))
        {
            System.out.println("Winner is: "+gameController.getWinner(game).getName());
        }
        else
        {
            System.out.println("Game Draw");
        }

    }
}
