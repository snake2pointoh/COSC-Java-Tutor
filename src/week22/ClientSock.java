package src.week22;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

public class ClientSock {

    static Socket sock;

    public static void main(String[] args) {


        try {
            sock = new Socket("localhost",2000);

            ObjectOutputStream obOut = new ObjectOutputStream(sock.getOutputStream());
            ObjectInputStream obIn = new ObjectInputStream(sock.getInputStream());

            obOut.writeUTF("This is from the client");

            // send data and teardown connection
            obOut.flush();
            obOut.close();
            obIn.close();
            sock.close();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
