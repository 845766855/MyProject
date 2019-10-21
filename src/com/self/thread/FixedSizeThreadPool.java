package com.self.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class FixedSizeThreadPool {

    //线程任务队列 超出最大size 不能再插入
    private BlockingQueue<Runnable> blockingQueue;
    //线程池
    private List<Thread> workers;

    //处理线程操作
    public static class Worker extends Thread {
        private FixedSizeThreadPool pool;
        @Override
        public void run() {

            while (this.pool.isWorking || this.pool.blockingQueue.size() > 0) {
                Runnable task = null;
                try {
                    if(this.pool.isWorking) {
                        task = this.pool.blockingQueue.take();
                    } else {
                        task = this.pool.blockingQueue.poll();
//                        System.out.println("poll a thread");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (task != null) {
                    task.run();
                    System.out.println("Thread " + Thread.currentThread().getName() + " running");
                }
            }

        }

        public Worker(FixedSizeThreadPool pool) {
            this.pool = pool;
        }
    }

    /**
     * 任务队列最大长度
     * @param poolSize
     * 最大线程池
     * @param taskSize
     */
    public FixedSizeThreadPool(int poolSize, int taskSize) {
        if(poolSize <= 0 || taskSize <= 0) {
            throw new IllegalArgumentException("illageal params");
        }
        this.blockingQueue = new LinkedBlockingQueue<Runnable>(taskSize);
        this.workers = Collections.synchronizedList(new ArrayList<Thread>());

        /**
         * 启动线程池
         */
        for (int i = 0; i < poolSize; i++) {
            Worker worker = new Worker(this);
            worker.start();
            workers.add(worker);
        }
    }

    /**
     * 插入任务队列
     * @param task
     * @return
     * @throws InterruptedException
     */
    public boolean submit(Runnable task) throws InterruptedException {
        if(isWorking) {
//            return this.blockingQueue.offer(task,2000L, TimeUnit.DAYS);
            return this.blockingQueue.offer(task);
        } else {
            return false;
        }
    }

    //线程池工作状态
    private volatile boolean isWorking = true;

    /**
     * 关闭线程池
     */
    public void shutDown() {
        this.isWorking = false;
        for (Thread thread: workers) {
            if(Thread.State.BLOCKED.equals(thread.getState())) {
                thread.interrupt();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FixedSizeThreadPool pool = new FixedSizeThreadPool(3,6);
        for (int i = 0; i <= 100;) {
            //任务队列已满  不继续插入  否则回返回false
            //任务无法执行
            //成功插入任务队列后 i +1 防止任务丢失
            if (pool.blockingQueue.size() < 6) {
//                System.out.println("insert "+ i + " thread");
                pool.submit(new TestDemo(i));
                i++;
            }
        }
//        System.out.println(" main end");
        pool.shutDown();
    }
}
