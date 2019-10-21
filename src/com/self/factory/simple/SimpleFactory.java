package com.self.factory.simple;

import com.self.factory.Audi;
import com.self.factory.Benz;
import com.self.factory.Bmw;
import com.self.factory.Car;

public class SimpleFactory {

    public Car getCar(String name) {
        if("BMW".equalsIgnoreCase(name)) {
            return new Bmw();
        } else if ("AUDI".equalsIgnoreCase(name)) {
            return new Audi();
        } else if ("BENZ".equalsIgnoreCase(name)) {
            return new Benz();
        } else {
            System.out.println("error input");
            return null;
        }
    }
}
