package src.week2;

import java.util.Scanner;

public class StringOr {
    public static void main(String[] args) {
        Scanner obIn = new Scanner(System.in);

        String pass = "saskpoly";
        String otherPass = "saskatoon";

        while(true) {
            System.out.println("enter the password (exit to cancel):");
            String guess = obIn.next();
            if(guess.equals(pass) || guess.equals(otherPass)) {
                System.out.println("correct password");
                break;
            }
            else {
                if(guess.equals("exit")) {
                    System.out.println("exited password entry");
                    break;
                }
                System.out.println("incorrect password");
            }
        }
    }
}
