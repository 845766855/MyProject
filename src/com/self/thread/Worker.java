package com.self.thread;

public class Worker extends Thread {
    MyThreadPoolDemo pool;

    public Worker(MyThreadPoolDemo pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        while (true) {
            Runnable task = null;
            try {
                task = pool.blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (task != null) {
                task.run();
                System.out.println("thread "+ Thread.currentThread().getName() + " running");
            }
        }
    }
}
