package com.tianhong.leetcode.Other;

public class Le1020NumberOfEnclaves {
    public int numEnclaves(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || i == m - 1 || j ==0 || j == n - 1){
                    floodFill(A, i, j);
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(A[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }

    public void floodFill(int[][] A, int x, int y) {
        if(inBoard(A, x, y) && A[x][y] == 1){
            A[x][y] = 0;
            floodFill(A, x - 1, y);
            floodFill(A, x + 1, y);
            floodFill(A, x, y - 1);
            floodFill(A, x, y + 1);
        }
    }

    public boolean inBoard(int[][] A, int x, int y) {
        if(x >= 0 && x < A.length && y >= 0 && y < A[0].length){
            return true;
        } else {
            return false;
        }
    }

}
