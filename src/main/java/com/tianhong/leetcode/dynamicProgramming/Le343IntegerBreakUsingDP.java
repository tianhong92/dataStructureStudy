package com.tianhong.leetcode.dynamicProgramming;

public class Le343IntegerBreakUsingDP {
    private int[] memo;
    public int integerBreak(int n) {
        if(n == 2)
            return 1;
        memo = new int[n + 1];
        memo[1] = 1;
        return devide(n);
    }

    public int devide(int n) {
        // 求解memo[i]
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i - 1; j++ ){
                memo[i] = Math.max(memo[i], Math.max(j * (i - j), j * memo[i - j]));
            }
        }
        return memo[n];
    }
}
