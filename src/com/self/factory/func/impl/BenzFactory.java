package com.self.factory.func.impl;

import com.self.factory.Benz;
import com.self.factory.Car;
import com.self.factory.func.Factory;

public class BenzFactory implements Factory {
    @Override
    public Car getCar() {
        return new Benz();
    }
}
