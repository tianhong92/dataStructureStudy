package com.tianhong.leetcode.Other;

import java.util.Arrays;

public class Le1072FlipColumns {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int total = 0;
        int r = matrix.length;
        int c = matrix[0].length;
        for(int i = 0; i < r; i++) {
            int count = 0;
            int[] flip = new int[c];
            for(int j = 0; i < c; j++) {
                flip[j] = 1 - matrix[i][j];
            }
            for(int k = 0; k < r; k++) {
                if(Arrays.equals(flip, matrix[k]) || Arrays.equals(matrix[k], matrix[i])){
                    count++;
                }
            }
            total = Math.max(count, total);
        }
        return total;
    }
}
