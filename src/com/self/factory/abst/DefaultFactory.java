package com.self.factory.abst;

import com.self.factory.Car;
import com.self.factory.abst.impl.AudiFactory;

/**
 * 默认Car
 */
public class DefaultFactory extends AbstractFactory {

    private AudiFactory defau = new AudiFactory();

    @Override
    protected Car getCar() {
        return defau.getCar();
    }
}
