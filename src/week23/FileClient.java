package src.week23;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class FileClient {

    static Socket connection;

    public static void main(String[] args) {
        Scanner cliIn = new Scanner(System.in);

        System.out.println("Enter a filename:");
        String fileName = cliIn.nextLine();

        try {
            connection = new Socket("localhost",2000);

            DataOutputStream obOut = new DataOutputStream(connection.getOutputStream());
            DataInputStream obIn = new DataInputStream(connection.getInputStream());

            obOut.writeUTF(fileName);

            String fileData = obIn.readUTF();

            FileWriter fileOut = new FileWriter("clientFiles/" + fileName);
            fileOut.write(fileData);
            fileOut.close();

            obOut.close();
            obIn.close();
            connection.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
