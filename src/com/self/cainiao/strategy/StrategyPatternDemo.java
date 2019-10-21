package com.self.cainiao.strategy;

public class StrategyPatternDemo {

    public static void main(String[] args) {
        ConText conText = new ConText(new OperatetionAdd());
        System.out.println(conText.excuteStrategy(1,3));

        conText = new ConText(new OperationSubstrace());
        System.out.println(conText.excuteStrategy(1,9));

        conText = new ConText(new OperationMultiply());
        System.out.println(conText.excuteStrategy(3,7));
    }
}
