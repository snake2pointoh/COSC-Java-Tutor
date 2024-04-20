package src.week24.sockets;


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Connect to the server.
 * Send and receive messages to and from the server.
 *
 * should not get its own messages passed back to itself
 */
public class SimpleClient {

    public static User clientUser;
    public static Socket socket;
    public static ObjectOutputStream sockOut;
    public static ObjectInputStream sockIn;

    public static boolean running = true;

    public static void main(String[] args) {

        try {
            socket = new Socket("localhost",2000);

            sockOut = new ObjectOutputStream(socket.getOutputStream());
            sockIn = new ObjectInputStream(socket.getInputStream());

            Packet connect = new Packet(null,null,PacketType.connect);
            sockOut.writeObject(connect);

            Thread listen = new Thread(SimpleClient::HandlePacketsThread);
            listen.start();

            Scanner cliIn = new Scanner(System.in);
            while (true) {
                String message = cliIn.nextLine();
                sockOut.writeObject(new Packet(clientUser, message, PacketType.message));
            }


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void HandlePacketsThread() {
        while (running) {
            try {
                Packet inPacket = (Packet) sockIn.readObject();

                switch (inPacket.getType()) {
                    case userAssign:
                        clientUser = (User) inPacket.getData();
                        break;
                    case message:
                        String message = (String) inPacket.getData();
                        System.out.printf("%s: %s\n",inPacket.getOwner().getName(), message);
                        break;
                    default:
                        break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
