package src.week22.common;

public class MessagePacket extends Packet {

    String message;

    public MessagePacket(String message) {
        super(PacketType.CLIENT_MESSAGE);
        this.message = message;
    }

    @Override
    public String getData() {
        return message;
    }
}
