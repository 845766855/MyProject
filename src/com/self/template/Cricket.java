package com.self.template;

public class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("Cricket Game Initialize! Start playing");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Start! Enjoy the game");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }
}
