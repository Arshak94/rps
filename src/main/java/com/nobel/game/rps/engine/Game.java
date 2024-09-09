package com.nobel.game.rps.engine;

import com.nobel.game.rps.model.Move;

public class Game {
    private final Player firstPlayer;
    private final EnginePlayer engine;
    private final GameStats gameStats;
    private boolean active;

    public Game(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
        this.engine = new EnginePlayer();
        gameStats = new GameStats();
        active = true;
    }

    public String play() {
        Move firstMove = firstPlayer.getMove();
        Move engineMove = engine.predictAndCounter();
        engine.updateMoveFrequency(firstMove);
        String result = determineWinner(firstMove, engineMove);
        updateGameStatistics(result);
        return result;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(final boolean active) {
        this.active = active;
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public GameStats getGameStats() {
        return gameStats;
    }

    private String determineWinner(Move playerMove, Move engineMove) {
        if (playerMove.equals(engineMove)) {
            return "DRAW";
        } else if ((playerMove.equals(Move.ROCK) && engineMove.equals(Move.SCISSORS)) ||
                (playerMove.equals(Move.PAPER) && engineMove.equals(Move.ROCK)) ||
                (playerMove.equals(Move.SCISSORS) && engineMove.equals(Move.PAPER))) {
            return "PLAYER_WIN";
        } else {
            return "ENGINE_WIN";
        }
    }

    private void updateGameStatistics(String result) {
        gameStats.setTotalGames(gameStats.getTotalGames() + 1);
        if (result.contains("PLAYER_WIN")) {
            gameStats.setPlayerWins(gameStats.getPlayerWins() + 1);
        } else if (result.contains("ENGINE_WIN")) {
            gameStats.setAiWins(gameStats.getAiWins() + 1);
        } else {
            gameStats.setDraws(gameStats.getDraws() + 1);
        }
    }
}
