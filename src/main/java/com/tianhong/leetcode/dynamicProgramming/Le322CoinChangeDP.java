package com.tianhong.leetcode.dynamicProgramming;

public class Le322CoinChangeDP {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        if(coins.length < 1 || amount < 0)
            return -1;
        // memo[i]表示凑齐i需要的最少币数
        int[] memo = new int[amount + 1];

        for(int i = 1; i <= amount; i++) {
            memo[i] = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i && memo[i - coins[j]] != Integer.MAX_VALUE)
                    memo[i] = Integer.min(memo[i], 1 + memo[i - coins[j]]);
            }
        }
        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5};
        Le322CoinChangeDP test = new Le322CoinChangeDP();
        test.coinChange(arr, 11);
    }
}
