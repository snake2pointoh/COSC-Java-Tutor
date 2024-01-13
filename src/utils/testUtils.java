package src.utils;

import java.io.IOException;
import java.io.RandomAccessFile;

public class testUtils {

    public static void main(String[] args) {
        try (RandomAccessFile obFile = new RandomAccessFile("files/test.raf", "rw")) {
            Utils.writeStringToRaf("Bryce", obFile, 10);
            Utils.writeStringToRaf("Michael", obFile, 10);
            Utils.writeStringToRaf("RichardLionHeart", obFile, 10);

            obFile.seek(20);
            System.out.printf("Read %s\n", Utils.readStringFromRaF(obFile, 10));

        } catch (IOException exp) {
            System.out.println(exp.getMessage());
        }
    }
}
