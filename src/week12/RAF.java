package src.week12;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RAF {
    public static void main(String[] args) {
        try(RandomAccessFile IO = new RandomAccessFile("files/raf.dat","rw")) {



            IO.writeInt(4);

            IO.writeBoolean(true);
            IO.writeBoolean(false);
            IO.writeBoolean(false); // 6
            IO.writeBoolean(true);

            IO.writeDouble(127.65);

            // read in booleans
            IO.seek(0);
            int count = IO.readInt();

            for (int i = 0; i < count; i++) {
                System.out.println(IO.readBoolean());
            }

            System.out.println(IO.readDouble());
            IO.seek(8);
            System.out.println(IO.readDouble());

            IO.seek(6);

            IO.writeBoolean(true);

            // read in booleans
            IO.seek(0);
            count = IO.readInt();

            for (int i = 0; i < count; i++) {
                System.out.println(IO.readBoolean());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
