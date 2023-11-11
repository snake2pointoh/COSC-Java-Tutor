package src.week8;

import java.util.Scanner;

public class Board {
    private static final char EMPTY_SPACE = '_';
    char[][] boardArray = {
            {EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE},
            {EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE},
            {EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE}
    };

    private Player[] players;

    private int currentPlayer;

    public Board(Player playerOne, Player playerTwo) {
        this.players = new Player[2];
        this.players[0] = playerOne;
        this.players[1] = playerTwo;

        this.currentPlayer = 0;
    }

    public void doMove(Scanner obIn) {
        while (true) {
            System.out.println("Enter an X,Y Position to place your piece");

            int xPos = obIn.nextInt();
            int yPos = obIn.nextInt();

            if (xPos < 0 || xPos > boardArray.length - 1) {
                continue;
            }
            if(yPos < 0 || yPos > boardArray[0].length - 1) {
                continue;
            }
            if(boardArray[xPos][yPos] != EMPTY_SPACE) {
                continue;
            }

            boardArray[xPos][yPos] = players[currentPlayer].getPlayerPiece();

            //update current player
            currentPlayer++;
            if(currentPlayer > players.length-1) {
                currentPlayer = 0;
            }

            break;
        }
    }

    public void drawBoard() {
        for (int i = 0; i < boardArray.length; i++) {
            for (int j = 0; j < boardArray[i].length; j++) {
                System.out.printf("%s\t", boardArray[i][j]);
            }
            System.out.printf("\n");
        }
    }

    /**
     * @return the player that won the game OR null if no win has occured
     */
    public Player winCheck() {
        // check each column for a win

        // check each row for a win

        // check diagonal for a win

        // make sure that there is still room to play / check for tie
        // if there is a tie
//        return new Player("Tie",EMPTY_SPACE);

        return null;
    }

}
