package com.tianhong.DIYDataStructure;

public class Main {
    public static void main(String[] args) {
        Array arr = new Array(10);
        for(int i = 0; i < 5; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.removeLast();
        System.out.println(arr);
    }
}

