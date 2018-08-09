package com.tianhong.DIYDataStructure.Queue;

public class Main {
    public static double testQueue(Queue<Integer> queue, int opCount){
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < opCount; i++){
            queue.enqueue(i);
        }
        for(int j = 0; j < opCount; j++){
            queue.dequeue();
        }
        long endTime = System.currentTimeMillis();
        return (endTime - startTime)/1000.0;
    }
    public static void main(String[] args) {
        int opCount = 100000;
        Queue<Integer> arrayQueue = new ArrayQueue<>();
        Queue<Integer> loopQueue = new LoopQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        double time2 = testQueue(loopQueue, opCount);
        System.out.println(time1);
        System.out.println(time2);
    }
}
