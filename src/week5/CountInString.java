package src.week5;

public class CountInString {
    public static void main(String[] args) {
        String myString = "saskpoly";

        int[] coutsForMyString = countInString(myString);

//        Arrays.printArray(coutsForMyString);
        printCharCount(coutsForMyString);

        System.out.println(coutsForMyString.length);

        System.out.println(coutsForMyString[coutsForMyString.length-1]); // print z count
    }

    public static int[] countInString(String strr) {
        int[] charCount = new int[26];

        for (int i = 0; i < strr.length();i++) {
            char currentChar = strr.charAt(i);

            int posInArray = currentChar - 'a'; // subtract ascii value of current char with ascii value of 'a'

            charCount[posInArray]++; //add one to the count
        }

        return charCount;
    }

    public static void printCharCount(int[] charCount) {
        char currentChar = 'a';
        for (int i = 0; i < charCount.length; i++) {
            System.out.printf("%s: %d\n", currentChar, charCount[i]);
            currentChar++;
        }
    }
}
