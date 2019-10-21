package com.self.thread;

public class ThreadDemo extends Thread {

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();
    }

    @Override
    public void run() {
        System.out.println("action");
    }
}
