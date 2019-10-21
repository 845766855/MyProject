package com.self.factory.func;

import com.self.factory.func.impl.AudiFactory;
import com.self.factory.func.impl.BenzFactory;
import com.self.factory.func.impl.BmwFactory;

public class FactoryTest {
    public static void main(String[] args) {
        Factory factory = new AudiFactory();
        System.out.println(factory.getCar());

        Factory factory1 = new BenzFactory();
        System.out.println(factory1.getCar());

        Factory factory2 = new BmwFactory();
        System.out.println(factory2.getCar());
    }
}
