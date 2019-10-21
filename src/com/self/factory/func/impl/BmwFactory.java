package com.self.factory.func.impl;

import com.self.factory.Benz;
import com.self.factory.Bmw;
import com.self.factory.Car;
import com.self.factory.func.Factory;

public class BmwFactory implements Factory {
    @Override
    public Car getCar() {
        return new Bmw();
    }
}
