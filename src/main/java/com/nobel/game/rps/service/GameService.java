package com.nobel.game.rps.service;

import com.nobel.game.rps.engine.GameStats;

public interface GameService {

    void start();

    String play(String move);

    void terminate();

    GameStats stats();
}
