package com.tianhong.leetcode.dynamic;

public class Le343IntegerBreakUsingRecursive {

    public int integerBreak(int n) {
        if(n <= 2)
            return 1;
        return divide(n);
    }

    public int divide(int n) {
        int res = 0;
        for(int i = 1; i <= n; i++) {
            res = Math.max(res, Math.max( i * (n - i), i * divide(n - i)));
        }
        return res;
    }
}
