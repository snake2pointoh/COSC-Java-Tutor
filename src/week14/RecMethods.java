package src.week14;

import java.util.ArrayList;

public class RecMethods {
    public static int recRoundRobin(int numTeams) {
        if(numTeams == 1) {
            return 0;
        }

        return numTeams -1 + recRoundRobin(numTeams - 1);
    }

    // count the number of occurrences of a word in a string
    public static int recCountWord(String sentence, String word) {
        if(sentence.isEmpty()) { // ""
            return 0;
        }

        int indexOfSpace = sentence.indexOf(" ");

        String currentWord;
        String remainder;

        if(indexOfSpace != -1) {
            currentWord = sentence.substring(0, indexOfSpace);
            remainder = sentence.substring(indexOfSpace + 1);
        } else {
            currentWord = sentence;
            remainder = "";
        }

        if(currentWord.equals(word)) {
            return 1 + recCountWord(remainder, word);
        } else {
            return recCountWord(remainder, word);
        }
    }

    // add the digits of an integer together
    public static int recSumDigits(int number) {
        if(number == 0) {
            return 0;
        }

        int digit = number % 10;
        return digit + recSumDigits(number/10);
    }

    // calculate the fib sequence up to a given number and push the sequence into an ArrayList
    public static ArrayList<Integer> calcFib(int count) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);

        recCalcFib(list, count - 2);

        return list;
    }


    public static void recCalcFib(ArrayList<Integer> list, int count) {
        if(count <= 0) {
            return;
        }

        int first = list.get(list.size()-1);
        int second = list.get(list.size()-2);

        list.add(first + second);

        recCalcFib(list, count - 1);
    }

}


