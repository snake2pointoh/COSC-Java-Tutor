package src.week2;

import java.util.Scanner;

public class CountEveryAlphaInString {
    public static void main(String[] args) {
        Scanner obIn = new Scanner(System.in);

        System.out.println("enter a word:");
        String word = obIn.next();

        for (int i = 'a'; i <= 'z'; i++) {
            int counter = 0;
            for (int j=0; j<word.length(); j++) {
                if(word.charAt(j) == (char)i) {
                    counter++;
                }
            }
            System.out.printf("the char: %s occurs %d times\n", (char)i, counter);
        }
    }
}
