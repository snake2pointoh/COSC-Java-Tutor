package src.week22;

import src.week22.common.Packet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class SimpleConnection {
    private Socket socket;
    private ObjectInputStream obIn;
    private ObjectOutputStream obOut;
    private Thread listenThread;
    private boolean isListen = true;

    public SimpleConnection(Socket socket) throws IOException {
        obOut = new ObjectOutputStream(socket.getOutputStream());
        obIn = new ObjectInputStream(socket.getInputStream());
    }

    public void initThead(ArrayList<SimpleConnection> connections) {
        listenThread = new Thread(()->{
           this.handleInput(connections);
        });

        listenThread.start();
    }

    public ObjectInputStream getObIn() {
        return obIn;
    }

    public ObjectOutputStream getObOut() {
        return obOut;
    }

    public Socket getSocket() {
        return socket;
    }

    // threaded method
    public void handleInput(ArrayList<SimpleConnection> connections) {
        try {
            while (isListen) {
                Packet packet = (Packet) obIn.readObject();
                switch (packet.getType()) {
                    case CLIENT_CONNECT:
                        handleClientConnectMessage(connections);
                        break;
                    case CLIENT_MESSAGE:
                        handleClientMessage(packet, connections);
                        break;
                    case CLIENT_DISCONNECT:
                        handleClientDisconnectMessage(connections);
                        break;
                }
            }

            close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void handleClientConnectMessage(ArrayList<SimpleConnection> connections) {
        try {
            for (SimpleConnection connection: connections) {
                connection.getObOut().writeUTF("A new client connected");
                connection.getObOut().flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleClientMessage(Packet packet, ArrayList<SimpleConnection> connections) {
        try {
            for (SimpleConnection connection: connections) {
                connection.getObOut().writeUTF(packet.getData());
                connection.getObOut().flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void handleClientDisconnectMessage(ArrayList<SimpleConnection> connections) {
        try {
            for (SimpleConnection connection: connections) {
                connection.getObOut().writeUTF("A client disconnected");
                connection.getObOut().flush();
            }

            connections.remove(this);
            isListen = false;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() throws IOException {
        obOut.close();
        obIn.close();
        socket.close();
    }
}
