package com.self.delegate.impl;

import com.self.delegate.IDelegate;

public class EmployA implements IDelegate {
    @Override
    public void doing() {
        System.out.println("employ A doing something");
    }
}
