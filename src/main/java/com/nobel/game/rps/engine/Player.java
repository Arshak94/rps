package com.nobel.game.rps.engine;

import com.nobel.game.rps.model.Move;

public class Player {

    private Move move;

    public void setMove(Move move) {
        this.move = move;
    }

    public Move getMove() {
        return move;
    }
}
