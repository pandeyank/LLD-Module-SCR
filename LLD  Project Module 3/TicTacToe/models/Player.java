package models;

import java.util.Scanner;

public class Player {
    private char symbol;
    private String name;
    private PlayerType playerType;

    public Player(char symbol, String name, PlayerType playerType) {
        this.symbol = symbol;
        this.name = name;
        this.playerType = playerType;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Moves decideMove(Board board) {
        System.out.println(this.getName() +" is deciding the move:");
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the row number:");
        int row=scanner.nextInt();
        System.out.println("Enter the coloumn number:");
        int col=scanner.nextInt();
        return new Moves(this,new Cell(row,col));
    }
}
