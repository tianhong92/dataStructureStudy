package com.tianhong.DaoFu;

public class RunnableDemo implements Runnable {
    private String name;
    RunnableDemo(String threadName){
        name = threadName;
    }

    @Override
    public void run(){
        System.out.println("Thread "+name+" start running...");
        for(int i = 4; i > 0; i--){
            System.out.println("Thread" + name + " " + i);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread "+name+" interrupted...");
        }
    }

    public static void main(String[] args){
        RunnableDemo r1 = new RunnableDemo("Thread-1");
        RunnableDemo r2 = new RunnableDemo("Thread-2");
        Thread t1 = new Thread(r1);
        t1.start();
        Thread t2 = new Thread(r2);
        t2.start();
    }
}