package com.self.thread;

import java.util.concurrent.ThreadPoolExecutor;

public class TestDemo implements Runnable {
    private int i;

    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo(1);
        testDemo.run();
    }

    public TestDemo(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("add a thread " + i);
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
