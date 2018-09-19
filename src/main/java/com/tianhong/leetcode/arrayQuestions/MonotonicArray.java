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
}
