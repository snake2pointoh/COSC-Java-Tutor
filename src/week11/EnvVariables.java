package src.week11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EnvVariables {
    public static void main(String[] args) {

        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        File myFile = new File(args[0]);

        try(Scanner obin = new Scanner(myFile)) {

            while (obin.hasNext()) {
                System.out.println(obin.nextLine());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
