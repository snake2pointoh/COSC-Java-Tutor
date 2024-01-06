package src.week11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CopyFile {
    // args[0] is the file to copy
    // args[1] is the name of the copy
    public static void main(String[] args) throws FileNotFoundException {
        if(args.length < 2) {
            System.out.println("Needs 2 arguments");
            System.exit(1);
        }

        File original = new File(args[0]);
        File copy = new File(args[1]);

        if(!original.exists()) {
            throw new FileNotFoundException("File to copy does not exist");
        }

        // check if the copy already exits, throw an error, or delete the copy

        try(Scanner obin = new Scanner(original);
            PrintWriter output = new PrintWriter(copy)) {

            while(obin.hasNext()) {
                output.println(obin.nextLine());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
