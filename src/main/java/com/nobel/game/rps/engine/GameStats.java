package com.nobel.game.rps.engine;

public class GameStats {

    private int totalGames;
    private int playerWins;
    private int aiWins;
    private int draws;

    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    public int getPlayerWins() {
        return playerWins;
    }

    public void setPlayerWins(int playerWins) {
        this.playerWins = playerWins;
    }

    public int getAiWins() {
        return aiWins;
    }

    public void setAiWins(int aiWins) {
        this.aiWins = aiWins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }
}
