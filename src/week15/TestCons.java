package src.week15;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class TestCons {
    public static void main(String[] args) {
        Consumer<String> printString = (s) -> System.out.println(s);
        BiConsumer<String, String> printTwoStrings = (s1,s2) -> System.out.printf("%s, %s", s1, s2);

        printString.accept("This is my string");

        printTwoStrings.accept("First String", "Second String");

        doThingToString("My Other String", printString);
        doThingToString("My Other String", TestCons::printFirstWord);
    }

    public static void doThingToString(String value, Consumer<String> func) {
        func.accept(value);
    }

    public static void printFirstWord(String value) {
        int indexSpace = value.indexOf(' ');

        String word;

        if(indexSpace != -1) {
            word = value.substring(0,indexSpace);
        } else {
            word = value;
        }

        System.out.println(word);
    }
}
