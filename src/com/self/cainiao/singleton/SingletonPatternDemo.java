package com.self.cainiao.singleton;

public class SingletonPatternDemo {

    public static void main(String[] args) {
        SingletonObject obj = SingletonObject.getInstance();
        obj.showMessage();
    }
}
