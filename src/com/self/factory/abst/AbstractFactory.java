package com.self.factory.abst;

import com.self.factory.Audi;
import com.self.factory.Benz;
import com.self.factory.Bmw;
import com.self.factory.Car;
import com.self.factory.abst.impl.AudiFactory;
import com.self.factory.abst.impl.BenzFactory;
import com.self.factory.abst.impl.BmwFactory;

public abstract class AbstractFactory {

    protected abstract Car getCar();

    public Car getCar(String name) {
        if("BMW".equalsIgnoreCase(name)) {
            return new BmwFactory().getCar();
        } else if ("AUDI".equalsIgnoreCase(name)) {
            return new AudiFactory().getCar();
        } else if ("BENZ".equalsIgnoreCase(name)) {
            return new BenzFactory().getCar();
        } else {
            System.out.println("error input");
            return null;
        }
    }
}
