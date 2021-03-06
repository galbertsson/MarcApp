package com.example.ohimarc.marc.model;

/**
 * @author Gustav Albertsson
 * <p>
 * Class for holding the statistics for a single deck/game mode combintaion
 */
public class Stat {
    private int highScore;
    private int timesPlayed;
    private boolean allCorrect;
    private double averageScore;
    private final String gameMode;

    /**
     * Creates a Stat object with default values,
     *
     * @param gameMode The game mode for which the Stat object is for
     */
    Stat(String gameMode) {
        this.gameMode = gameMode;
        highScore = 0;
        timesPlayed = 0;
        averageScore = 0;
        this.allCorrect = false;
    }

    /**
     * Creates a Stat object that is an deep copy of the given stat object.
     *
     * @param s The Stat object to make a deep copy of.
     */
    Stat(Stat s) {
        gameMode = s.gameMode;
        highScore = s.highScore;
        averageScore = s.averageScore;
        timesPlayed = s.timesPlayed;
        allCorrect = s.allCorrect;
    }

    /**
     * Updates the statistics that that is saved based on the given score.
     *
     * @param score The score that the user got.
     */
    public void updateStat(int score, int deckSize) {
        highScore = Math.max(highScore, score);
        averageScore = ((averageScore * timesPlayed) + score) / (timesPlayed + 1);
        timesPlayed++;
        allCorrect = allCorrect || deckSize == score;
    }

    /**
     * @return The average score of the Stat.
     */
    public double getAverageScore() {
        return averageScore;
    }

    /**
     * @return The high score of the Stat.
     */
    public int getHighScore() {
        return highScore;
    }

    /**
     * @return The game mode of the Stat.
     */
    public String getGameMode() {
        return gameMode;
    }

    /**
     * @return The number of times played of the Stat.
     */
    public int getTimesPlayed() {
        return timesPlayed;
    }

    /**
     * @return True if all answers were correct, false otherwise.
     */
    public boolean getAllCorrect() {
        return allCorrect;
    }
}
