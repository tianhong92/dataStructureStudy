package com.tianhong.leetcode.dynamicProgramming;

// F(n, c)将n个物体放入容量为c的背包， 求价值最大值
// F(n, c) = max( v(n) + F(n - 1, c - w(n)), F(n - 1, c) )

public class KnapsackDP {
    // w数组代表重量; v数组代表价值; c代表背包的容量
    public int knapsack(int[] w, int[] v, int c) {
        int n = w.length;
        if(n == 0 || n != v.length)
            return 0;
        int[][] dp = new int[n][c + 1];
        for(int i = 0; i <= c; i++) {
            dp[0][i] = w[0] <= i ? v[0] : 0;
        }

        for(int j = 1; j < n; j++){
            for(int k = 0; k <= c; k++) {
                dp[j][k] = dp[j - 1][k];
                if(k >= w[j]){
                    dp[j][k] = Math.max(dp[j][k], v[j] + dp[j - 1][k - w[j]]);
                }
            }
        }
        return dp[n - 1][c];
    }
}
