package src.week11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile {
    public static void main(String[] args) {
        
        // Create a file object for the desired file
        File myFile = new File("files/testFile.txt");

        // Check if the file already exits
        if(myFile.exists()) {
            System.out.println("File Already Exists");
            System.exit(1);
        }

        // Create a writer to create and write to the file
        try(PrintWriter output = new PrintWriter(myFile)) {

            // Write text to the file
            output.println("this is a test.");
            output.println("Create a new line");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

//        PrintWriter output;
//        try {
//            output = new PrintWriter(myFile);
//
//            output.println("this is a line of text");
//            output.print("this is");
//            output.println(" another Line");
//
//            output.close();
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }

    }
}
