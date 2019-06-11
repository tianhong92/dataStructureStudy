package com.tianhong.leetcode.Other;

public class Le1020NumberOfEnclaves {
    private boolean[][] taken;
    public int numEnclaves(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        taken = new boolean[m][n];
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(A[i][j] == 1)
                    count = Math.max(floodFill(A, i, j, 1), count);
            }
        }
        return count;
    }

    public int floodFill(int[][] A, int x, int y, int size) {
        if(notOnEdge(A, x, y) && A[x][y] == 1) {

        }
        return 0;
    }

    public boolean notOnEdge(int[][] A, int x, int y) {
        int m = A.length;
        int n = A[0].length;
        return x > 0 && x < m - 1 && y > 0 && y < n - 1 ? true : false;
    }
}
