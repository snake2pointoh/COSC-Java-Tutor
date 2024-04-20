package src.week24.sockets;

import java.io.Serializable;

public class Packet implements Serializable {
    private User owner;
    private Object data;
    private PacketType type;

    public Packet(User owner, Object data, PacketType type) {
        this.owner = owner;
        this.data = data;
        this.type = type;
    }

    public PacketType getType() {
        return type;
    }

    public Object getData() {
        return data;
    }

    public User getOwner() {
        return owner;
    }
}
