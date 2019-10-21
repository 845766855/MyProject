package com.self.delegate;

import com.self.delegate.impl.Dispatcher;
import com.self.delegate.impl.EmployA;

public class DispatcherTest {

    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher(new EmployA());
        dispatcher.doing();
    }
}
