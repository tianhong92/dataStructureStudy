package com.tianhong.leetcode.dynamicProgramming.knapSack;

public class Le416PartitionEqualSubsetSumDP2 {
    public boolean canPartition(int[] nums) {
        if(nums.length < 2)
            return false;
        int total = 0;
        for(int num : nums){
            total += num;
        }
        if(total % 2 != 0)
            return false;
        int C = total / 2;
        boolean[] dp = new boolean[C + 1];
        for(int i = 0; i <= C; i++) {
            if(nums[0] == i)
                dp[i] = true;
        }
        for(int i = 1; i < nums.length; i++){
            for(int j = C; i >= 0; j--) {
                if(j >= nums[i])
                    dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[C];
    }
}
