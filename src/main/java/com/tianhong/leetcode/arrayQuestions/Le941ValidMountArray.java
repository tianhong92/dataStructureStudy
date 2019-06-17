package com.tianhong.leetcode.arrayQuestions;

public class Le941ValidMountArray {
    public boolean validMountainArray(int[] A) {
        if(A.length < 3){
            return false;
        }
        boolean climb = true;
        for(int i = 1; i < A.length; i++) {
            if(A[i] == A[i - 1]) {
                return false;
            } else if (A[i] < A[i - 1]) {
                if(i == 1) {
                    return false;
                } else {
                    climb = false;
                }
            } else if (!climb) {
                return false;
            }
        }
        return true && !climb;
    }
}
