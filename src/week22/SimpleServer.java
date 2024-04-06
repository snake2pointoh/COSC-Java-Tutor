package src.week22;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class SimpleServer {

    static ArrayList<SimpleConnection> connections = new ArrayList<>();
    static ServerSocket serverSocket;
    static boolean running = false;

    public static void main(String[] args) {

        try {
            serverSocket = new ServerSocket(2000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // try to create and add connections while running
        running = true;
        Thread connectThread = new Thread(SimpleServer::acceptConnections);
        connectThread.start();



    }

    public static void acceptConnections() {
        while (running) {
            try {
                Socket clientSocket = serverSocket.accept();

                // set-up each connection
                synchronized (connections) {
                    SimpleConnection connection = new SimpleConnection(clientSocket);
                    connections.add(connection);
                    connection.initThead(connections);
                    System.out.println("new client");
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}