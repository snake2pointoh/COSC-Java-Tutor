package src.week16;

import java.io.*;

public class DataIO {
    public static void main(String[] args) {
        WriteFile("files/ExampleDataIO.dat");
        ReadFile("files/ExampleDataIO.dat");
    }

    public static void WriteFile(String fileName) {
        try (DataOutputStream obOut = new DataOutputStream(new FileOutputStream(fileName))) {

            obOut.writeInt(1234);
            obOut.writeBoolean(true);
            obOut.writeChar('A');
            obOut.writeDouble(12.5);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ReadFile(String fileName) {
        try (DataInputStream obIn = new DataInputStream(new FileInputStream(fileName))) {

            System.out.println(obIn.readInt());
            System.out.println(obIn.readBoolean());
            System.out.println(obIn.readChar());
            System.out.println(obIn.readDouble());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
