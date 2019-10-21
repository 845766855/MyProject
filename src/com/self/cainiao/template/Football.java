package com.self.cainiao.template;

public class Football extends Game {
    @Override
    void initialize() {
        System.out.println("Football Game initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football game sharted! Enjoy the game.");
    }

    @Override
    void endPlay() {
        System.out.println("Football game finished!");
    }

    @Override
    public void testMethod() {
        System.out.println("Football end");
    }
}
