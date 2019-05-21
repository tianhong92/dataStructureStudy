package com.tianhong.leetcode.dynamicProgramming;

// F(n, c)将n个物体放入容量为c的背包， 求价值最大值
// F(n, c) = max( v(n) + F(n - 1, c - w(n)), F(n - 1, c) )

public class KnapsackDP {
    // w数组代表重量; v数组代表价值; c代表背包的容量
    public int knapsack(int[] w, int[] v, int c) {
        if(w.length != v.length || c == 0 || w.length == 0)
            return 0;
        int[][] dp = new int[2][c + 1];
        for(int q = 0; q <= c; q++){
            dp[0][q] = w[0] >= q ? v[0] : 0;
        }

        for(int i = 1; i < w.length; i++) {
            for(int j = 0; j <= c; j++) {
                dp[i%2][j] = dp[(i - 1)%2][j];
                if(w[i] <= j) {
                    dp[i%2][j] = Math.max(dp[i%2][j], v[i] + dp[(i - 1)%2][j - w[i]]);
                }
            }
        }
        return dp[(w.length - 1)%2][c];
    }
}
