package com.gigaden;

import com.gigaden.service.GameService;

public class App
{
    public static void main( String[] args ) {
        GameService gameService = new GameService();

        gameService.startGame();
    }
}
