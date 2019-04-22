package com.tianhong.DaoFu;

public class RunnableDemo2 {
    int count;
    class RunnableInner implements Runnable {
        private String name;
        RunnableInner(String threadName){
            name = threadName;
        }

        @Override
        public void run(){
            System.out.println("Thread " + name + " start running...");
            synchronized(this){
                for(int i = 0; i < 5; i++){
                    count++;
                }
            }
            System.out.println("Thread " + name + " i= "+count);
        }
    }

    public static void main(String[] args){
        RunnableDemo2 demo = new RunnableDemo2();
        RunnableInner inner = demo.new RunnableInner("Thread-1");
        for(int i = 0; i < 10000; i++){
            new Thread(inner).start();
        }
    }

}
