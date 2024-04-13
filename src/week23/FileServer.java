package src.week23;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class FileServer {

    static ServerSocket serverSocket;

    public static void main(String[] args) {

        try {
            serverSocket = new ServerSocket(2000);

            Thread connThread = new Thread(FileServer::handleConnections);
            connThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void handleConnections() {
        while (true) {
            try {
                Socket connection = serverSocket.accept();

                DataOutputStream obOut = new DataOutputStream(connection.getOutputStream());
                DataInputStream obIn = new DataInputStream(connection.getInputStream());

                String filename = obIn.readUTF();

                File fileToSend = new File("files/" + filename);

                if(!fileToSend.exists()) {
                    obIn.close();
                    obOut.close();
                    connection.close();
                    continue;
                }

                Scanner fileData = new Scanner(fileToSend);
                String fileContents = "";

                while (fileData.hasNextLine()) {
                    fileContents += fileData.nextLine();
                }

                obOut.writeUTF(fileContents);
                obOut.flush();

                // close connection
                obOut.close();
                obIn.close();
                connection.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
