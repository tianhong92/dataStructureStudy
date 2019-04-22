package com.tianhong.DaoFu;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class RunnableDemo3 {
    private static AtomicInteger ai = new AtomicInteger(0);
    private static CountDownLatch cdl = new CountDownLatch(1000);

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(100);
        for(int i = 0; i < 1000; i++){
            exec.execute(new Runnable(){
                @Override
                public void run(){
                    System.out.println("Thread "+ Thread.currentThread().getName() + " ai = " + ai.incrementAndGet());
                    cdl.countDown();
                }
            });
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ai);
        exec.shutdown();

    }
}
