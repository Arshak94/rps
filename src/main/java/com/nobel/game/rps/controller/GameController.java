package com.nobel.game.rps.controller;

import com.nobel.game.rps.engine.GameStats;
import com.nobel.game.rps.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GameController {

    private final GameService gameService;

    public GameController(final GameService gameService) {
        this.gameService = gameService;
    }


    @PostMapping("/start")
    public String startGame() {
        gameService.start();
        return "Started";
    }

    @PostMapping("/play")
    public String playGame(@RequestParam String move) {
        return gameService.play(move);
    }

    @PostMapping("/terminate")
    public String terminateGame() {
        gameService.terminate();
        return "Game terminated.";
    }

    @GetMapping("/statistics")
    public GameStats getStatistics() {
        return gameService.stats();
    }
}
