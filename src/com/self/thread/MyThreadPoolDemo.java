package com.self.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPoolDemo {

    public BlockingQueue<Runnable> blockingQueue;

    private List<Thread> workers;

    public boolean submit(Runnable task) {
        return blockingQueue.offer(task);
    }

    public MyThreadPoolDemo(int poolSize, int workSize) {
        if (poolSize <= 0 || workSize <= 0) {
            throw new IllegalArgumentException("illegal params");
        }
        this.blockingQueue = new LinkedBlockingQueue<Runnable>(workSize);
        this.workers = Collections.synchronizedList(new ArrayList<Thread>());

        for (int i = 0; i < poolSize; i++) {
            Worker worker = new Worker(this);
            worker.start();
            workers.add(worker);
        }
    }

    public static void main(String[] args) {
        MyThreadPoolDemo poolDemo = new MyThreadPoolDemo(3,6);
        for (int i = 0; i < 10; i++) {
            poolDemo.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("a new thread add");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
