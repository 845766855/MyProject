package com.self.factory.func.impl;

import com.self.factory.Audi;
import com.self.factory.Car;
import com.self.factory.func.Factory;

public class AudiFactory implements Factory {
    @Override
    public Car getCar() {
        return new Audi();
    }
}
