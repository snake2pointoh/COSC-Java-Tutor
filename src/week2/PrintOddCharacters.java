package src.week2;

import java.util.Scanner;

public class PrintOddCharacters {
    public static void main(String[] args) {
        // the user enter a sentace
        // print out every character in the odd position
        // EX: saskpoly
            // output: sspl

        Scanner obIn = new Scanner(System.in);
        System.out.println("enter a sentence:");
        String sentence = obIn.nextLine();

        String oddSentence = "";

        for (int i = 0; i < sentence.length(); i++) {
            if(i % 2 == 0) {
                oddSentence += sentence.charAt(i);
            }
        }

        System.out.println(oddSentence);
    }
}
