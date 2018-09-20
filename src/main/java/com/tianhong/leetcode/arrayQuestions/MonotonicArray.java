package com.tianhong.leetcode.arrayQuestions;

public class MonotonicArray {
    // Input: [1,2,2,3] Output: true
    // Input: [6,5,4,4] Output: true
    // Input: [1,1,1] Output: true
    // Input: [1,3,2] Output: false
    public boolean isMonotonic(int[] A) {
        if(A.length == 1)
            return true;
        boolean isIncrease = false;
        boolean isDecrease = false;
        for(int i = 0; i < A.length - 1; i++){
            if(A[i+1] > A[i]){
                isIncrease = true;
            } else if(A[i+1] < A[i]) {
                isDecrease = true;
            }
            if(isIncrease && isDecrease)
                return false;
        }
        return true;
    }

    public boolean isMonotonic2(int[] A){
        return increasing(A) || decreasing(A);
    }

    public boolean increasing(int[] A){
        for(int i = 0; i < A.length - 1; i++){
            if(A[i+1] < A[i])
                return false;
        }
        return true;
    }

    public boolean decreasing(int[] A){
        for(int i = 0; i < A.length - 1; i++){
            if(A[i+1] > A[i])
                return false;
        }
        return true;
    }

    // One pass
    public boolean isMonotonic3(int[] A){
        int store = 0;
        for(int i = 0; i < A.length - 1; i++){
            int temp = Integer.compare(A[i+1], A[i]);
            if(store != 0 && temp != store && temp != 0)
                return false;
            if(temp != 0)
                store = temp;
        }
        return true;
    }

    public static void main(String[] args) {
        MonotonicArray array = new MonotonicArray();
        int[] test = new int[]{1,2,2,3};
        boolean rst = array.isMonotonic3(test);
    }
}
