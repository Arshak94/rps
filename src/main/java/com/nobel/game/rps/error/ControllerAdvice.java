package com.nobel.game.rps.error;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler
    public Error handle(IllegalArgumentException e) {
        return new Error(e.getMessage());
    }
}
