package com.tianhong.leetcode.dynamic;

public class Le279PerfectSquaresUsingDP {
    // 动态规划
    public int numSquares(int n) {
        if(n <= 2)
            return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        // 求解dp[i]
        for(int i = 3; i <= n; i++){
            int j = 1;
            int res = i;
            while(i - j * j >= 0) {
                res = Math.min(res, 1 + dp[i - j * j]);
                j++;
            }
            dp[i] = res;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Le279PerfectSquaresUsingDP test = new Le279PerfectSquaresUsingDP();
        int res = test.numSquares(5);
        System.out.println(res);
    }
}
