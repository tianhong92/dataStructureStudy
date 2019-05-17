package com.tianhong.leetcode.dynamicProgramming;

// F(n, c)将n个物体放入容量为c的背包， 求价值最大值
// F(n, c) = max( v(n) + F(n - 1, c - w(n)), F(n - 1, c) )


public class KnapsackQuestion {
    int[][] memo;
    // w数组代表重量; v数组代表价值; c代表背包的容量
    public int knapsack(int[] w, int[] v, int c) {
        memo = new int[w.length][c + 1];
        return maxValue(w, v, c, w.length - 1);
    }

    public int maxValue(int[] w, int[] v, int c, int index) {
        if(index < 0 || c < 0)
            return 0;
        if(memo[index][c] != 0)
            return memo[index][c];
        int max = maxValue(w, v, c, index - 1);
        if(c >= w[index])
             max = Math.max(max, v[index] + maxValue(w, v, c - w[index], index - 1));
        return max;
    }
}
