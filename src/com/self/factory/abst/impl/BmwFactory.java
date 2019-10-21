package com.self.factory.abst.impl;

import com.self.factory.Bmw;
import com.self.factory.Car;
import com.self.factory.abst.AbstractFactory;

public class BmwFactory extends AbstractFactory {
    @Override
    public Car getCar() {
        return new Bmw();
    }
}
