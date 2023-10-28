package src.week6;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
//        char[][] board = new char[3][3];
        Scanner obIn = new Scanner(System.in);
        char[][] board = {
                {'_','_','_'},
                {'_','_','_'},
                {'_','_','_'}
        };

        char xPiece = 'X';
        char oPiece = 'O';

        char currentPiece = xPiece;

        while (true) {
            drawBoard(board);

            doMove(board, obIn, currentPiece);

            if(currentPiece == xPiece) {
                currentPiece = oPiece;
            }
            else {
                currentPiece = xPiece;
            }

            // check for a win
        }
    }

    public static void doMove(char[][] board, Scanner obIn, char piece) {
        while (true) {
            System.out.println("Pick an X and a Y position to place your piece");

            int xPos = obIn.nextInt();
            int yPos = obIn.nextInt();

            // if the positions are NOT on the board Pick again
            if(xPos > board[0].length-1 || xPos < 0) {
                continue;
            }
            if(yPos > board.length-1 || yPos < 0) {
                continue;
            }

            // if the position has a piece then pick again
            if(board[yPos][xPos] != '_') {
                continue;
            }

            board[yPos][xPos] = piece;
            break;
        }

    }

    public static void placePiece(char[][] board, int x, int y, char piece){
        board[y][x] = piece;
    }

    public static void drawBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char currentChar = board[i][j];
                System.out.printf("%s\t",currentChar);
            }
            System.out.println();
        }
    }
}
