package com.tianhong.DIYDataStructure.MaxHeap;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // 利用堆排序
        Long start = System.currentTimeMillis();
        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for(int i = 0; i < n; i++)
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = maxHeap.extractMax();
        for(int i = 1; i < n; i++){
            if(arr[i-1] < arr[i])
                throw new IllegalAccessError("error");
        }
        Long end = System.currentTimeMillis();
        System.out.println("completed " + (end - start)/1000.0);
    }

    private static double testHeap(Integer[] testData, boolean isHeapify){
        long startTime = System.currentTimeMillis();
        MaxHeap<Integer> maxHeap;
        if(isHeapify)
            maxHeap = new MaxHeap<>(testData);
        else{
            maxHeap = new MaxHeap<>();
            for(int num : testData)
                maxHeap.add(num);
        }
        long endTime = System.currentTimeMillis();
        return (endTime - startTime)/1000.0;
    }
}
