package com.tianhong.leetcode.dynamicProgramming;

import java.util.Arrays;

public class Le931MinimumFallingPathSumDP {
    public int minFallingPathSum(int[][] A) {
        int length = A.length;
        int N = A[0].length;
        int[][] B = new int[length][N];
        for(int i = 0; i < N; i++) {
            B[0][i] = A[0][i];
        }
        for(int i = 1; i < length; i++) {
            for(int j = 0; j < N; j++) {
                int left = 101, mid = 101, right = 101;
                if(j - 1 >= 0)
                    left = B[i - 1][j - 1];
                if(j >= 0 && j < N)
                    mid = B[i - 1][j];
                if(j + 1 >= 0 && j + 1 < N)
                    right = B[i - 1][j + 1];
                B[i][j] = A[i][j] + Math.min(Math.min(left, mid), right);
            }
        }
        int min = B[length - 1][0];
        for(int i = 1; i < N; i++) {
            if(B[length - 1][i] < min)
                min = B[length - 1][i];
        }
        return min;
    }

}
