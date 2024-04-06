package src.week22;

import src.week22.common.ConnectPacket;
import src.week22.common.DisconnectPacket;
import src.week22.common.MessagePacket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SimpleClient {
    static Socket socket;
    static ObjectOutputStream obOut;
    static ObjectInputStream obIn;

    static Thread listenThread;
    static boolean listen = true;

    public static void main(String[] args) {

        try {
            socket = new Socket("localhost", 2000);

            obOut = new ObjectOutputStream(socket.getOutputStream());
            obIn = new ObjectInputStream(socket.getInputStream());

            listenThread = new Thread(SimpleClient::listenThreadMethod);
            listenThread.start();
            doConnect();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner consIn = new Scanner(System.in);
        while (true) {
            String command = consIn.nextLine();

            if (command.equals("message")) {
                doMessage("This is a message");
            }
            if (command.equals("exit")) {
                doDisconnect();
            }
        }

    }

    private static void close() throws IOException {
        obOut.close();
        obIn.close();
        socket.close();
    }

    private static void doConnect() {
        try {
            obOut.writeObject(new ConnectPacket());
            obOut.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void doMessage(String message) {
        try {
            obOut.writeObject(new MessagePacket(message));
            obOut.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void doDisconnect() {
        try {
            obOut.writeObject(new DisconnectPacket());
            obOut.flush();
            listen = false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void listenThreadMethod() {
        System.out.println("Listening...");
        try {
            while (listen) {
                System.out.println(obIn.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
