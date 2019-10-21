package com.self.factory.abst.impl;

import com.self.factory.Audi;
import com.self.factory.Car;
import com.self.factory.abst.AbstractFactory;

public class AudiFactory extends AbstractFactory {
    @Override
    public Car getCar() {
        return new Audi();
    }
}
