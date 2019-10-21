package com.self.cainiao.strategy;

public class OperatetionAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
