package com.tianhong.leetcode.Other;

import java.util.List;

public class Le931MinimumFallingPathSum {
    private int total = Integer.MAX_VALUE;
    public int minFallingPathSum(int[][] A) {
        for(int i = 0 ; i < A[0].length; i++) {
            backTrack(A, 1, i, A[0][i]);
        }
        return total;
    }

    public void backTrack(int[][] A, int level, int index, int sum) {
        if(level == A.length) {
            if(sum < total)
                total = sum;
            return;
        }
        if(index - 1 >= 0 && index - 1 < A[0].length)
            backTrack(A, level + 1, index - 1, sum + A[level][index - 1]);
        if(index >= 0 && index < A[0].length)
            backTrack(A, level + 1, index, sum + A[level][index]);
        if(index + 1 >= 0 && index + 1 < A[0].length)
            backTrack(A, level + 1, index + 1, sum + A[level][index + 1]);
    }




    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        Le931MinimumFallingPathSum test = new Le931MinimumFallingPathSum();
        test.minFallingPathSum(arr);
    }
}
