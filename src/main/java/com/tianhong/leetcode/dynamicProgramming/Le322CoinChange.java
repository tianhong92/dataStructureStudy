package com.tianhong.leetcode.dynamicProgramming;

import java.util.Arrays;

public class Le322CoinChange {
    private int minCount = -1;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if(amount == 0)
            return 0;
        if(coins[0] < 0 || amount < 0 || coins[0] > amount)
            return -1;
        coinAmount(coins, amount, 0);
        return minCount;
    }

    public void coinAmount(int[] coins, int remain, int amount) {
        if (remain < 0)
            return;
        if (remain == 0) {
            if (minCount == -1)
                minCount = amount;
            else
                minCount = amount < minCount ? amount : minCount;
        }
        for (int i = 0; i < coins.length; i++) {
            coinAmount(coins, remain - coins[i], amount + 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5};
        Le322CoinChange test = new Le322CoinChange();
        System.out.println(test.coinChange(arr, 30));
    }
}
