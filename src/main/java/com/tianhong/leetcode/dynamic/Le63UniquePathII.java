package com.tianhong.leetcode.dynamic;

public class Le63UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length < 1 || obstacleGrid[0].length < 1)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] grid = new int[m][n];
        if(obstacleGrid[0][0] != 1) {
            grid[0][0] = 1;
            for (int i = 1; i < m; i++) {
                if (obstacleGrid[i - 1][0] != 1) {
                    grid[i][0] = 1;
                } else {
                    break;
                }
            }

            for(int j = 1; j < n; j++) {
                if(obstacleGrid[0][j - 1] != 0) {
                    grid[0][j] = 1;
                } else {
                    break;
                }
            }
        }
        for(int k = 1; k < m; k++) {
            for(int t = 1; t < n; t++) {
                grid[k][t] = grid[k - 1][t] + grid[k][t - 1];
            }
        }
        return grid[m - 1][n - 1];

    }
}
