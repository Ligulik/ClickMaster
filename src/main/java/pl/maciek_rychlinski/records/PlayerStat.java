package pl.maciek_rychlinski.records;

import java.io.FileNotFoundException;
import java.io.IOException;

public class PlayerStat {
    private String playerName;
    private String playerScore;
    private String dateOfGame;

    public PlayerStat() {
    }

    public PlayerStat(String playerName, String playerScore, String dateOfGame) {
        this.playerName = playerName;
        this.playerScore = playerScore;
        this.dateOfGame = dateOfGame;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(String playerScore) {
        this.playerScore = playerScore;
    }

    public String getDateOfGame() {
        return dateOfGame;
    }

    public void setDateOfGame(String dateOfGame) {
        this.dateOfGame = dateOfGame;
    }

public static void main(String[] arg) throws FileNotFoundException, IOException {
        SaveRecord saveRecord=new SaveRecord();
        LoadRecord loadRecord=new LoadRecord();
}
}
