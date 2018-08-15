package com.tianhong.DIYDataStructure;

import com.tianhong.DIYDataStructure.Array.Array;
import com.tianhong.DIYDataStructure.Stack.ArrayStack;
import com.tianhong.DIYDataStructure.Stack.LinkListStack;
import com.tianhong.DIYDataStructure.Stack.Stack;

public class Main {
    public static double opTime(int opCount, Stack<Integer> stack){
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < opCount; i++){
            stack.push(i);
        }
        for(int j = 0; j < opCount; j++) {
            stack.pop();
        }
        long endTime = System.currentTimeMillis();
        return (endTime - startTime)/1000.0;
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();
        Stack<Integer> stack2 = new LinkListStack<>();
        int opCount = 100000;
        double opTime1 = opTime(opCount, stack);
        double opTime2 = opTime(opCount, stack2);

        System.out.println("Array stack: "+opTime1);
        System.out.println("Linked list stack: "+opTime2);
    }
}

