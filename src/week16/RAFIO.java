package src.week16;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RAFIO {
    public static void main(String[] args) {

        try (RandomAccessFile raf = new RandomAccessFile("files/ExampleRAF.dat","rw")) {


            // Write
            raf.writeBoolean(true);
            raf.writeBoolean(false);

            raf.writeDouble(256.78);

            String myStr = "This is a string";
            raf.writeInt(myStr.length());
            raf.writeUTF(myStr);

            // seek
            raf.seek(1);
            raf.writeBoolean(true); // cursor at position 2

            raf.seek(0);

            // Read
            System.out.println(raf.readBoolean());
            System.out.println(raf.readBoolean());

            System.out.println(raf.readDouble());

            System.out.println(raf.readInt());
            System.out.println(raf.readUTF());


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
