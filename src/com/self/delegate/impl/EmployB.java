package com.self.delegate.impl;

import com.self.delegate.IDelegate;

public class EmployB implements IDelegate {
    @Override
    public void doing() {
        System.out.println("employ B doing something");
    }
}
