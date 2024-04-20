package src.week24.sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection {
    private Socket socket;
    private User user;
    private ObjectOutputStream connOut;
    private ObjectInputStream connIn;

    public Connection(Socket socket, User user) throws IOException {
        this.socket = socket;
        this.user = user;

        connOut = new ObjectOutputStream(socket.getOutputStream());
        connIn = new ObjectInputStream(socket.getInputStream());
    }

    public Socket getSocket() {
        return socket;
    }

    public User getUser() {
        return user;
    }

    public ObjectOutputStream getConnOut() {
        return connOut;
    }

    public ObjectInputStream getConnIn() {
        return connIn;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Connection)) {
            return false;
        }

        Connection other = (Connection) obj;

        if(this.user.getUid() != other.user.getUid()) {
            return false;
        }

        return true;
    }
}
