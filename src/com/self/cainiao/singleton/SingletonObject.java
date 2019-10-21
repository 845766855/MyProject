package com.self.cainiao.singleton;

public class SingletonObject {

    //常规
    private static SingletonObject instance = new SingletonObject();
    private SingletonObject() {

    }

    public static SingletonObject getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }

    /*//懒汉式 线程不安全
    public static SingletonObject instance;
    private SingletonObject(){}
    public static SingletonObject getInstance() {
        if (instance == null) {
            instance = new SingletonObject();
        }
        return instance;
    }*/

    /*//懒汉式 线程安全
    public static SingletonObject instance;
    private SingletonObject(){}
    public static synchronized SingletonObject getInstance() {
        if (instance == null) {
            instance = new SingletonObject();
        }
        return instance;
    }*/

    /*//饿汉式
    private static SingletonObject instance = new SingletonObject();
    private SingletonObject(){}
    public static SingletonObject getInstance() {
        return instance;
    }*/

    /*//双检锁 双重校验锁（DLC  double-checked locking）
    private volatile static SingletonObject instance;
    private SingletonObject(){}
    public static SingletonObject getInstance() {
        if (instance == null) {
            synchronized (SingletonObject.class) {
                if (instance == null) {
                    instance = new SingletonObject();
                }
            }
        }
        return instance;
    }*/

    /*//登记式 静态内部类
    private static class SingletonHolder {
        private static final SingletonObject INSTANCE = new SingletonObject();
    }
    private SingletonObject(){}
    public static final SingletonObject getInstance() {
        return SingletonHolder.INSTANCE;
    }*/

    //枚举

}
