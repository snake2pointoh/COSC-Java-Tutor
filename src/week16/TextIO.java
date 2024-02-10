package src.week16;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextIO {
    public static void main(String[] args) {
        WriteFile("files/ExampleFile.txt");
        ReadFile("files/ExampleFile.txt");
    }

    public static void WriteFile(String fileName) {
        try (PrintWriter obOut = new PrintWriter(fileName)) {

            obOut.println("This is some text");
            obOut.println("Here is some more");
            obOut.println("the last line");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ReadFile(String fileName) {
        try (Scanner obIn = new Scanner(new File(fileName))) {

            while (obIn.hasNext()) {
                System.out.println(obIn.nextLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
