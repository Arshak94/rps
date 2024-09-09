package com.nobel.game.rps.engine;

import com.nobel.game.rps.model.Move;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EnginePlayer {

    private final Move[] moves = {Move.ROCK, Move.PAPER, Move.SCISSORS};
    private final Map<Move, Integer> moveFrequency = new HashMap<>();
    private final Random random = new Random();

    public EnginePlayer() {
        moveFrequency.put(Move.ROCK, 0);
        moveFrequency.put(Move.PAPER, 0);
        moveFrequency.put(Move.SCISSORS, 0);
    }

    public void updateMoveFrequency(Move playerMove) {
        moveFrequency.put(playerMove, moveFrequency.get(playerMove) + 1);
    }

    public Move predictAndCounter() {
        Move mostFrequentMove = getMostFrequentMove();

        return switch (mostFrequentMove) {
            case ROCK -> Move.PAPER;  // counter rock with paper
            case PAPER -> Move.SCISSORS;  // counter paper with scissors
            case SCISSORS -> Move.ROCK;  // counter scissors with rock
            default -> generateRandomMove();
        };
    }

    private Move getMostFrequentMove() {
        return moveFrequency.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }

    private Move generateRandomMove() {
        return moves[random.nextInt(moves.length)];
    }


}
