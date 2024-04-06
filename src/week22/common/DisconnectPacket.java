package src.week22.common;

public class DisconnectPacket extends Packet {

    public DisconnectPacket() {
        super(PacketType.CLIENT_DISCONNECT);
    }

    @Override
    public String getData() {
        return "";
    }
}
