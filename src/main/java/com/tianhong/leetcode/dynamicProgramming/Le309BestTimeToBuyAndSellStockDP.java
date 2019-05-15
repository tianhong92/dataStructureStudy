package com.tianhong.leetcode.dynamicProgramming;

public class Le309BestTimeToBuyAndSellStockDP {
    public int maxProfit(int[] prices) {
        int preSell = 0, preRest = 0, preBuy = 0;
        int length = prices.length;
        // 可买
        int[] s0 = new int[length];
        // 可卖
        int[] s1 = new int[length];
        // 必须休息
        int[] s2 = new int[length];
        s0[0] = 0;
        s1[0] = 0;
        s2[0] = 0;
        for(int i = 1; i < length; i++) {
            s0[i] = Math.max(s2[i - 1], s0[i - 1]);
            s1[i] = Math.max(s0[i - 1] - prices[i - 1], s1[i - 1]);
            s2[i] = s1[i - 1] + prices[i - 1];
        }

    }
}
