package src.week24.sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class SimpleServer {

    public static ArrayList<Connection> connections = new ArrayList<>();
    public static User serverUser = new User("Server", 0);
    public static ServerSocket serverSocket;
    public static boolean run = true;
    public static int currentID = 1;

    public static void main(String[] args) {

        try {
            serverSocket = new ServerSocket(2000);

            Thread listen = new Thread(SimpleServer::HandleNewConnThread);
            listen.start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void HandleNewConnThread() {
        while (run) {
            try {
                Socket newSocket = serverSocket.accept();

                User newUser = new User("User: " + currentID, currentID);
                currentID += 1;

                Connection newConn = new Connection(newSocket, newUser);
                synchronized (connections) {
                    connections.add(newConn);
                }

                new Thread(()->{
                    HandleSingleConnectionThread(newConn);
                }).start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void HandleSingleConnectionThread(Connection conn) {
        boolean running = true;

        while (running) {
            try {
                Packet inPacket = (Packet) conn.getConnIn().readObject();

                Packet outPacket;

                switch (inPacket.getType()) {
                    case connect:
                        outPacket = new Packet(serverUser, conn.getUser(), PacketType.userAssign);
                        conn.getConnOut().writeObject(outPacket);
                        break;
                    case message:
                        String message = (String) inPacket.getData();

                        for (Connection connection: connections) {
                            if (connection.getUser().getUid() == conn.getUser().getUid()) {
                                continue;
                            }

                            outPacket = new Packet(conn.getUser(), message, PacketType.message);
                            connection.getConnOut().writeObject(outPacket);
                        }
                        break;
                    case disconnect:
                        running = false;
                        synchronized (connections) {
                            connections.remove(conn);
                        }
                        break;
                    default:
                        break;
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
