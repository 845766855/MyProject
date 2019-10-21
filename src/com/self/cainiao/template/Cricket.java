package com.self.cainiao.template;

public class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("Cricket Game initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket game sharted! Enjoy the game.");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket game finished!");
    }
}
