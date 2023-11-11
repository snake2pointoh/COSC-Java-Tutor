package src.week8;

public class Player {
    private String playerName;
    private char playerPiece;

    public Player(String name, char piece) {
        this.playerName = name;
        this.playerPiece = piece;
    }

    public char getPlayerPiece() {
        return playerPiece;
    }

    public String getPlayerName() {
        return playerName;
    }
}
