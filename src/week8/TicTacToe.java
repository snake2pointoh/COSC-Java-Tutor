package src.week8;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Player p1 = new Player("Bob",'X');
        Player p2 = new Player("Bill",'O');

        Scanner obIn = new Scanner(System.in);

        Board gameBoard = new Board(p1,p2);

        Player winner = null;

        gameBoard.drawBoard();

        do {
            gameBoard.doMove(obIn);
            gameBoard.drawBoard();

            winner = gameBoard.winCheck();
        } while(winner == null);

        System.out.printf("the winner is: $s", winner.getPlayerName());

    }
}
