package com.self.cainiao.template;

public abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    public void testMethod() {
        System.out.println("end game");
    }

    public final void play() {
        initialize();
        startPlay();
        endPlay();
        testMethod();
    }
}
