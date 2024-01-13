package src.week12;

import java.io.*;

public class DataStream {
    public static void main(String[] args) {
        writeData("files/dataStream.dat");
        readData("files/dataStream.dat");
    }

    private static void writeData(String filename) {
        try(DataOutputStream output = new DataOutputStream(new FileOutputStream(filename))) {

//            output.writeInt(124673);
            output.writeUTF("test data");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readData(String filename) {
        try(DataInputStream input = new DataInputStream(new FileInputStream(filename))) {

            System.out.println(input.readUTF());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
