package src.week16;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIO {
    public static void main(String[] args) {

        WriteFile("files/ExampleFIO.dat");
        ReadFile("files/ExampleFIO.dat");

    }

    public static void WriteFile(String fileName) {
        try(FileOutputStream obOut = new FileOutputStream(fileName)) {

            obOut.write(10);
            obOut.write(4);
            obOut.write(12);
            obOut.write(15);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ReadFile(String fileName) {
        try (FileInputStream obIn = new FileInputStream(fileName)) {

            System.out.println(obIn.read());
            System.out.println(obIn.read());
            System.out.println(obIn.read());
            System.out.println(obIn.read());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
