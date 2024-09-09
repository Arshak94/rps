package com.nobel.game.rps.service;

import com.nobel.game.rps.engine.Game;
import com.nobel.game.rps.engine.GameStats;
import com.nobel.game.rps.engine.Player;
import com.nobel.game.rps.model.Move;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    private Game game;

    @Override
    public void start() {
        this.game = new Game(new Player());
    }

    @Override
    public String play(String move) {
        if (game == null || !game.isActive()) {
            return "No active game. Start a new game first.";
        }
        game.getFirstPlayer().setMove(Move.valueOf(move));
        return game.play();
    }

    @Override
    public void terminate() {
        if (game != null) {
            game.setActive(false);
        }
    }

    @Override
    public GameStats stats() {
        if (game == null) {
            return new GameStats();
        }
        return game.getGameStats();
    }
}
