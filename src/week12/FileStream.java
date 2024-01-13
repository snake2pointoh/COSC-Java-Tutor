package src.week12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStream {
    public static void main(String[] args) {
        writeFile("files/fileStream.dat");
        readFile("files/fileStream.dat");
    }

    private static void writeFile(String filename) {
        try(FileOutputStream output = new FileOutputStream(filename)) {

            for(int i = 1; i <= 20; i++ ) {
                output.write(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile(String filename) {
        try(FileInputStream input = new FileInputStream(filename)) {
            int value;
            while((value = input.read()) != -1) {
                System.out.println(value);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
