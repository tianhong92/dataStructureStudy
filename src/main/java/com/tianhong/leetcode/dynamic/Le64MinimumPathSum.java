package com.tianhong.leetcode.dynamic;

//  Input:
//  [
//      [1,3,1],
//      [1,5,1],
//      [4,2,1]
//  ]
// Output: 7
// Explanation: Because the path 1→3→1→1→1 minimizes the sum.
// Note: You can only move either down or right at any point in time.

public class Le64MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid.length < 1 || grid[0].length < 1)
            return 0;
        int x = grid.length;
        int y = grid[0].length;

        for (int i = 1; i < y; i++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }

        for (int j = 1; j < x; j++) {
            grid[j][0] = grid[j - 1][0] + grid[j][0];
        }

        for(int k = 1; k < x; k++){
            for(int t = 1; t < y; t++){
                int up = grid[k - 1][t];
                int left = grid[k][t - 1];
                grid[k][t] = up < left ? up + grid[k][t] : left + grid[k][t];
            }
        }
        return grid[x - 1][y - 1];
    }
}
