package com.tianhong.leetcode.dynamicProgramming;

public class Le198HouseRobberDP {
    public int rob(int[] nums) {
       if(nums.length < 1)
           return 0;
       // dp[i] 代表 抢劫[0...i]的最大值
       int[] dp = new int[nums.length];
       dp[0] = nums[0];
       for(int i = 1; i < nums.length; i++) {
           int res = dp[i - 1];
           // 求抢劫[0...i]的最大值
           for(int j = 0; j <= i; j++) {
               if(j - 2 >= 0) {
                   res = Math.max(res, nums[j] + dp[j - 2]);
               } else {
                   res = Math.max(res, nums[j]);
               }
           }
           dp[i] = res;
       }
       return dp[nums.length - 1];
    }
}
