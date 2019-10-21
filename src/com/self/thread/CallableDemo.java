package com.self.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableDemo {


    public static void main(String[] args) throws Exception {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Random random = new Random();
                return "return:" + random.nextInt(100);
            }
        };

        FutureTask<String> futureTask = new FutureTask<String>(callable);
        new Thread(futureTask).start();

        String result = futureTask.get();//阻塞主线程 知道Callable执行完成
        System.out.println(result);
    }
}
