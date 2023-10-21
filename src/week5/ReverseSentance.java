package src.week5;

import java.util.Scanner;

public class ReverseSentance {
    public static void main(String[] args) {
//        String myStr = "Welcome To Saskpoly";

        Scanner obIn = new Scanner(System.in);
        String myStr = obIn.nextLine();

        // "Saskpoly To Welcome"
        System.out.println(reverseFromFirst(myStr));
        System.out.println(reverseFromLast(myStr));
    }


    public static String reverseFromFirst(String strr) {
        String newSentence = "";

        while (strr.length() > 0) {
            // find the first word
            int indexOfSpace = strr.indexOf(' ');
            //space was found
            if (indexOfSpace != -1) {
                String word = strr.substring(0, indexOfSpace); //does not include the space
                newSentence = word + " " + newSentence;
                strr = strr.substring(indexOfSpace + 1);
            } else {
                newSentence = strr + " " + newSentence;
                strr = "";
            }
        }

        return newSentence.trim();
    }

    public static String reverseFromLast(String strr) {
        String newSentence = "";

        while (strr.length()>0) {
            int indexOfSpace = strr.lastIndexOf(' ');
            if(indexOfSpace != -1) {
                String word = strr.substring(indexOfSpace+1);
                newSentence += " " + word;

                strr = strr.substring(0,indexOfSpace);
            }
            else {
                newSentence += " " + strr;
                strr = "";
            }

        }

        return newSentence.trim();
    }
}
