package com.tianhong.DIYDataStructure;

import com.tianhong.DIYDataStructure.Array.Array;

public class Main {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(10);
        for(int i = 0; i < 5; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
        for(int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.removeLast();
        for(int i =0; i<10; i++){
            arr.removeLast();
        }
        System.out.println(arr);
    }
}

