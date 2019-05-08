package com.tianhong.leetcode.dynamicProgramming;

/**
 * @author TianhongWang
 * @since 2019/4/23
 */
public class Le70ClimbStairs {

    public int climbStairs(int n) {
        int[] steps = new int[n];
        return getSteps(steps, n);
    }

    public int getSteps(int[] steps, int n) {
        if(n < 2)
            return n;
        steps[0] = 0;
        steps[1] = 1;
        steps[2] = 2;
        for(int i = 3; i <= n; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[n];
    }
}
