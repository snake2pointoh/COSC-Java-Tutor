package src.week24.sockets;
import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private int uid; // id 0 is reserved for the server

    public User(String name, int uid) {
        this.name = name;
        this.uid = uid;
    }

    public int getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }
}
