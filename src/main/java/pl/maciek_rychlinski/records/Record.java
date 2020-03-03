/**
 * POJO
 */

package pl.maciek_rychlinski.records;

public class Record {
    private String playerName="Default";
    private String dateOfPlay="Default";
    private String clockOFPlay="Default";
    private int Score=0;

    public Record() {
    }

    public Record(String playerName, String dateOfPlay, String clockOFPlay, int score){
        this.playerName = playerName;
        this.dateOfPlay = dateOfPlay;
        this.clockOFPlay = clockOFPlay;
        Score = score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getDateOfPlay() {
        return dateOfPlay;
    }

    public void setDateOfPlay(String dateOfPlay) {
        this.dateOfPlay = dateOfPlay;
    }

    public String getClockOFPlay() {
        return clockOFPlay;
    }

    public void setClockOFPlay(String clockOFPlay) {
        this.clockOFPlay = clockOFPlay;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }


}
