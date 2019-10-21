package com.self.delegate.impl;

import com.self.delegate.IDelegate;
import com.sun.xml.internal.bind.v2.model.core.ID;

public class Dispatcher implements IDelegate {
    IDelegate exector;

    public Dispatcher(IDelegate exector) {
        this.exector = exector;
    }
    @Override
    public void doing() {
        this.exector.doing();
    }
}
