package com.tianhong.leetcode.arrayQuestions;
// Input: [0,1,0]
// Output: 1
// Input: [0,2,1,0]
// Output: 1
public class PeakIndex852 {
    public int peakIndexInMountainArray(int[] A) {
        for(int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1])
                return i - 1;
        }
        return -1;
    }
}
