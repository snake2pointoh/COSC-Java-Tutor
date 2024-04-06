package src.week22.common;

public class ConnectPacket extends Packet {

    public ConnectPacket() {
        super(PacketType.CLIENT_CONNECT);
    }

    @Override
    public String getData() {
        return "";
    }
}
