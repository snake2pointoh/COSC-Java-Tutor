package src.week2;

import java.util.Scanner;

public class CountWords {
    public static void main(String[] args) {
        Scanner obIn = new Scanner(System.in);
        System.out.println("enter a sentence:");

        String sentence = obIn.nextLine();

        // while there are still characters slpit on next space and add one to
        // a counter if the word is longer than 5
        int counter = 0;
        while (sentence.length() > 0) {
            String word = "";
            // if there is a space, remove the word before the space
            // remove the word from the sentence
            if(sentence.indexOf(' ') != -1) {
                word = sentence.substring(0, sentence.indexOf(' '));
                sentence = sentence.substring(sentence.indexOf(' ')+1);
            }
            // if there is no space then there is only one word left
            // so set word to be sentence and clear the sentence
            else {
                word = sentence;
                sentence = "";
            }

            // add one to the counter if the word is longer then 5
            if(word.length() > 5) {
                counter++;
            }
        }

        System.out.println(counter);
    }
}
