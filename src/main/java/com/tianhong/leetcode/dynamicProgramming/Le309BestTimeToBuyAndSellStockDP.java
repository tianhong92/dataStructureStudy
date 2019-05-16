package com.tianhong.leetcode.dynamicProgramming;

public class Le309BestTimeToBuyAndSellStockDP {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length <= 1)
            return 0;
        int[] buy = new int[length];
        int[] rest = new int[length];
        int[] sell = new int[length];
        buy[0] -= prices[0];
        rest[0] = 0;
        sell[0] = 0;
        for(int i = 1; i < length; i++) {
            buy[i] = Math.max(buy[i - 1], rest[i - 1] - prices[i]);
            sell[i] = buy[i - 1] + prices[i];
            rest[i] = Math.max(sell[i - 1], rest[i - 1]);
        }
        return Math.max(sell[length - 1], rest[length - 1]);
    }
}
