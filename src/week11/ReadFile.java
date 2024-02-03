package src.week11;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {

        // Create a file object for the desired file
        File myFile = new File("files/testFile.txt");

        // Scan the files contents
        try(Scanner input = new Scanner(myFile)) {

            // While there is still content in the file print each line to the console
            while (input.hasNext()) {
                String line = input.nextLine();
                System.out.println(line);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
