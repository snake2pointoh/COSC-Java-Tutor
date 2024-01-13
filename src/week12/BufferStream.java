package src.week12;

import java.io.*;

public class BufferStream {
    public static void main(String[] args) {

        writeBuffer("files/bufferStream.dat");
        readBuffer("files/bufferStream.dat");

    }

    private static void writeBuffer(String filename) {
        try(BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filename))) {

            outputStream.write(10);
            outputStream.write(12);
            outputStream.write(4);

            outputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readBuffer(String filename) {
        try(BufferedInputStream inputBuffer = new BufferedInputStream(new FileInputStream(filename))) {

            System.out.println(inputBuffer.read());
            System.out.println(inputBuffer.read());
            System.out.println(inputBuffer.read());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
