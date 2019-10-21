package com.self.cainiao.observer;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new BinaryObserver(subject);
        new OctalObserver(subject);

        System.out.println("first state change:15");
        subject.setState(15);
        System.out.println("second state change:10:");
        subject.setState(10);
    }
}
