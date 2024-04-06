package src.week22;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSock {

    static ServerSocket serverSocket;

    public static void main(String[] args) {

        //Start Server
        try {
            serverSocket = new ServerSocket(2000);

            Socket connection = serverSocket.accept();

            ObjectOutputStream obOut = new ObjectOutputStream(connection.getOutputStream());
            ObjectInputStream obIn = new ObjectInputStream(connection.getInputStream());

            System.out.println(obIn.readUTF());

            // teardown connection
            obIn.close();
            obOut.close();
            connection.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
