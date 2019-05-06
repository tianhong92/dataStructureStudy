package com.tianhong.leetcode.dynamic;

public class Le63UniquePaths {
    public int uniquePaths(int m, int n) {
        if(m < 1 || n < 1)
            return 0;
        int[][] dp = new int[n][m];
        for(int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }
        for(int j = 0; j < n; j++) {
            dp[j][0] = 1;
        }
        for(int k = 1; k < n; k++) {
            for(int t = 1; t < m; t++) {
                dp[k][t] = dp[k - 1][t] + dp[k][t - 1];
            }
        }
        return dp[n - 1][m - 1];
    }
}
