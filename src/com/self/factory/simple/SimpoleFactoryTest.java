package com.self.factory.simple;

import com.self.factory.Car;

public class SimpoleFactoryTest {

    public static void main(String[] args) {
        Car car = new SimpleFactory().getCar("BMW1");
        if (car != null) {
            System.out.println(car.getName());
        }
    }
}
