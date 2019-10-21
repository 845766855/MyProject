package com.self.factory.abst.impl;

import com.self.factory.Benz;
import com.self.factory.Car;
import com.self.factory.abst.AbstractFactory;

public class BenzFactory extends AbstractFactory {
    @Override
    public Car getCar() {
        return new Benz();
    }
}
