package com.tianhong.leetcode.dynamicProgramming;

import java.util.Arrays;

public class Le322CoinChangeDP {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if(amount == 0)
            return 0;
        if(coins[0] < 0 || amount < 0 || coins[0] > amount)
            return -1;
        int[][] memo = new int[coins.length][amount + 1];
        for(int i = 0; i <= amount; i++) {
            if(i % coins[0] == 0) {
                memo[0][i] = i / coins[0];
            }
        }
        for(int i = 1; i < coins.length; i++) {
            for(int j = amount; j >= coins[i]; j--) {
                memo[i][j] = memo[i - 1][j];
                if(j % coins[i] == 0){
                    memo[i][j] = j / coins[i];
                } else {
                    int temp = j / coins[i];
                    if(memo[i - 1][j - temp * coins[i]] != 0)
                        memo[i][j] = temp + memo[i - 1][j - temp * coins[i]];
                }
            }
        }
        return memo[coins.length - 1][amount] == 0 ? -1 : memo[coins.length - 1][amount];
    }

    public static void main(String[] args) {
        System.out.println(1 % 6);
    }
}
