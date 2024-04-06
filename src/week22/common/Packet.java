package src.week22.common;

import java.io.Serializable;

public abstract class Packet implements Serializable {
    private PacketType type;

    public Packet(PacketType type) {
        this.type = type;
    }

    public PacketType getType() {
        return type;
    }

    public abstract String getData();
}
