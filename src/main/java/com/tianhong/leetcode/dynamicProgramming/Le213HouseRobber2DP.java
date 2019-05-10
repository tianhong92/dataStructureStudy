package com.tianhong.leetcode.dynamicProgramming;

public class Le213HouseRobber2DP {
    public int rob(int[] nums) {
        if(nums.length < 1)
            return 0;
        int[] dp1 = new int[nums.length - 1];
        int[] dp2 = new int[nums.length];
        return Math.max(tryRob(nums, 0, nums.length - 2, dp1), tryRob(nums, 1, nums.length - 1, dp2));
    }

    // 尝试抢劫[start...end]范围内的房子
    public int tryRob(int[] nums, int start, int end, int[] dp) {
        if(start > end)
            return 0;
        // 抢劫[start, i]的房子
        dp[start] = nums[start];
        for(int i = start; i <= end; i++) {
            int res = nums[start];
            for(int j = start; j <= i; j++) {
                if(j - 2 >= start)
                    res = Math.max(res, nums[j] + dp[j - 2]);
                else
                    res = Math.max(res, nums[j]);
            }
            dp[i] = res;
        }
        return dp[end];
    }
}
