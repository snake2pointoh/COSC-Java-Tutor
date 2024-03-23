package src.week21;

public class GameResult {

    private String gameName;
    private int gameScore;

    public GameResult(String gameName, int gameScore) {
        this.gameName = gameName;
        this.gameScore = gameScore;
    }

    public int getGameScore() {
        return gameScore;
    }

    public String getGameName() {
        return gameName;
    }
}
