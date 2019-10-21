package com.self.factory.abst;

public class AbsFactoryTest {

    public static void main(String[] args) {
        DefaultFactory defaultFactory = new DefaultFactory();
        System.out.println(defaultFactory.getCar("Benz"));
        System.out.println(defaultFactory.getCar());
    }
}
