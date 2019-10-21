package com.self.singleton;

/**
 * 懒汉模式
 */
public class Sigleton1 {

    private static class LazyHolder {
        private static final Sigleton1 INSTANCE = new Sigleton1();

    }

    private Sigleton1() {

    }

    public static final Sigleton1 getInstance() {
        return LazyHolder.INSTANCE;
    }

}
