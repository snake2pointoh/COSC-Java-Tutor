package src.week2;

import java.util.Scanner;

public class CountInStringExample {
    // take a string input and char input and count the number of times the char
    // occurs in the string
    public static void main(String[] args) {
        Scanner obIn = new Scanner(System.in);

        System.out.println("enter a word:");
        String word = obIn.next();

        System.out.println("enter a char:");
        char checkChar = obIn.next().charAt(0);

        int counter = 0;

        for(int i=0; i < word.length(); i++ ) {
            if(word.charAt(i) == checkChar) {
                counter++;
            }
        }

        System.out.printf("the char %s occurs %d times in the word %s\n",
                checkChar, counter, word);

    }

}
