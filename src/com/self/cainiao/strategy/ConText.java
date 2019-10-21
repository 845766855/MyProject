package com.self.cainiao.strategy;

public class ConText {
    private Strategy strategy;

    public ConText(Strategy strategy) {
        this.strategy = strategy;
    }
    public int excuteStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
