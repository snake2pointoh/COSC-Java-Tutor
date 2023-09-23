package src.week2;

import java.util.Scanner;

public class SameStartingWord {
    public static void main(String[] args) {
        // have the user enter two sentences
        //      hello world
        //      hello nick
        // if they both start with the SAME wor then
        // output "both start with (word)"
        //      "both start with hello"
        // if not then output "they dont start with the same word"
        //      hello world
        //      goodbye world
        // output: they dont start with the same word

        Scanner obIn = new Scanner(System.in);

        System.out.println("enter the first Sentence:");
        String sentenceOne = obIn.nextLine();

        System.out.println("enter the second Sentence:");
        String sentenceTwo = obIn.nextLine();

        // placeholder values for the first words in each sentence
        String startOfOne = ""; // hello if sentence one is hello world
        String startOfTwo = "";

        if(sentenceOne.indexOf(' ') != -1) {
            startOfOne = sentenceOne.substring(0,sentenceOne.indexOf(' '));
        } else {
            startOfOne = sentenceOne;
        }

        if(sentenceTwo.indexOf(' ') != -1) {
            startOfTwo = sentenceTwo.substring(0,sentenceTwo.indexOf(' '));
        } else {
            startOfTwo = sentenceTwo;
        }

        if(startOfOne.equals(startOfTwo)) {
            System.out.printf("both start with %s\n", startOfOne);
        } else {
            System.out.println("they dont start with the same word");
        }

    }
}
