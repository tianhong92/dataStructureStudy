package com.tianhong.leetcode.arrayQuestions;

// Input: A = [1,1], B = [2,2]
// Output: [1,2]

import java.util.HashMap;

public class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int totalA = 0;
        int totalB = 0;
        for(int t = 0; t < A.length; t++)
            totalA += A[t];
        for(int k = 0; k < B.length; k++)
            totalB += B[k];
        int diff = totalB - totalA;
        int[] ret = new int[2];
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            hash.put((diff + 2*A[i])/2, A[i]);
        }
        for(int j = 0; j < B.length; j++){
            if(hash.containsKey(B[j])){
                ret[0] = hash.get(B[j]);
                ret[1] = B[j];
            }
        }
        return ret;
    }
}
