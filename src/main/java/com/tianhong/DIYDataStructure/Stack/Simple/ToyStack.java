package com.tianhong.DIYDataStructure.Stack.Simple;

/**
 * @author TianhongWang
 * @since 2019/2/14
 */
public class ToyStack {
    // 当前堆栈深度
    private int length = 0;
    private int maxLength = 10;
    private int[] stack = new int[maxLength];

    private int push(int n){
        if(length == maxLength){
            throw new RuntimeException("Stack of out bound!");
        }
        return stack[length++] = n;
    }

    private int pop(){
        if(length == 0){
            throw new RuntimeException("Stack is empty!");
        }
        return stack[--length];
    }

    private int peek(){
        if(length == 0){
            throw new RuntimeException("Stack is empty!");
        }
        return stack[length-1];
    }

    public static void main(String[] args) {
        ToyStack stack = new ToyStack();
        for(int i = 0; i < 11; i++){
            stack.push(i);
        }
        System.out.println(stack.length);
    }
}
