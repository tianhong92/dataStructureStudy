package com.tianhong.leetcode.dynamicProgramming;

public class Le309BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length < 1)
            return 0;
        return getMaxProfit(prices, true, false, 0, 0);
    }

    public int getMaxProfit(int[] prices, boolean canBuy, boolean canSell, int index, int current) {
        if(index > prices.length - 1)
            return current;
        if(canBuy && !canSell) {
            return Math.max(getMaxProfit(prices, false, true, index + 1, current - prices[index]),
                    getMaxProfit(prices, true, false, index + 1, current));
        } else if (!canBuy && canSell) {
            return Math.max(getMaxProfit(prices, false, false, index + 1, current + prices[index]),
                    getMaxProfit(prices, false, true, index + 1, current));
        } else {
            return getMaxProfit(prices, true, false, index + 1, current);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 1, 2, 3, 0, 6};
        Le309BestTimeToBuyAndSellStock test = new Le309BestTimeToBuyAndSellStock();
        System.out.println(test.maxProfit(arr));
    }
}
