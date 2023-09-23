package src.week2;

import java.util.Scanner;

public class ReplaceChar {
    public static void main(String[] args) {
        Scanner obIn = new Scanner(System.in);
        String sentence = obIn.nextLine();

        char replaceChar = 'a';
        char relpaceWithchar = '7';

        String newString = "";

        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == replaceChar) {
                newString += relpaceWithchar;
            }
            else
            {
                newString += sentence.charAt(i);
            }
        }

        System.out.println(newString);
    }
}
