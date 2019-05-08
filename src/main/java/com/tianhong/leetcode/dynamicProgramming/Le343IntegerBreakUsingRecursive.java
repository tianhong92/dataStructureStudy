package com.tianhong.leetcode.dynamicProgramming;

public class Le343IntegerBreakUsingRecursive {

    private int[] memo;
    public int integerBreak(int n) {
        if(n <= 2)
            return 1;
        memo = new int[n + 1];
        memo[2] = 1;
        return divide(n);
    }

    public int divide(int n) {
        if(n <= 2)
            return n;
        if(memo[n] != 0)
            return memo[n];
        int res = 0;
        for(int i = 1; i <= n; i++){
            res = Math.max(res, Math.max(i * (n - i), i * divide(n - i)));
        }
        memo[n] = res;
        return memo[n];
    }

    public static void main(String[] args) {
        Le343IntegerBreakUsingRecursive test = new Le343IntegerBreakUsingRecursive();
        test.integerBreak(10);
    }
}
