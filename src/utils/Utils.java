package src.utils;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Utils {
    private final static char TERM_CHAR = '\0';

    /**
     * Method will write out a string to the raf file  using frameSize bytes .
     * If the string is less than frame-size bytes, we will pad with the TERM_CHAR
     * If greater, the string will be truncated.
     *
     * @param sVal       String to write out to file
     * @param obRAF      Random access file
     * @param nFrameSize How big a "frame" we are going to fit the record in.
     */
    public static void writeStringToRaf(String sVal, RandomAccessFile obRAF, int nFrameSize) throws IOException {
        byte[] aWriteBytes = sVal.getBytes();
        int i = 0;

        for (; i < Math.min(aWriteBytes.length, nFrameSize); i++) {
            obRAF.writeByte(aWriteBytes[i]);
        }

        for (; i < nFrameSize; i++) {
            obRAF.writeByte(TERM_CHAR);
        }

    }

    public static String readStringFromRaF(RandomAccessFile obRAF, int nFrameSize) throws IOException {
        //Read frame-size bytes from the Random access file
        byte[] aReadBytes = new byte[nFrameSize];

        obRAF.read(aReadBytes);  // Reads aReadBytes.length bytes from the file

        String sReturn = new String(aReadBytes);

        int nPos = sReturn.indexOf(TERM_CHAR);
        if (nPos != -1) {
            return sReturn.substring(0, nPos);
        } else {
            return sReturn;
        }

    }

    /**
     * This method will parse a Single line from a csv file in an appropriate fashion.
     * @param sLine String
     * @return String[]
     */
    public static String[] parseCSV(String sLine)
    {
        String sPattern = ",(?=([^\"]*\"[^\"]*\")*(?![^\"]*\"))";
        String [] sFields = sLine.split(sPattern);

        //Get rid of remaining double quotes
        for (int i=0; i< sFields.length; i++)
        {
            sFields[i] = sFields[i].replace("\"", "");

        }
        return sFields;
    }
}
