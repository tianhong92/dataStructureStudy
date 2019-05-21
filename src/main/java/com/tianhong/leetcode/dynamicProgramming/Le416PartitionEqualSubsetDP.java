package com.tianhong.leetcode.dynamicProgramming;

public class Le416PartitionEqualSubsetDP {
    public boolean canPartition(int[] nums) {
        if(nums.length < 2)
            return false;
        int total = 0;
        for(int num : nums){
            total += num;
        }
        if(total % 2 != 0)
            return false;
        int target = total / 2;
        boolean[] memo = new boolean[target + 1];
        for(int i = 0; i <= target; i++){
            memo[i] = (nums[0] == target);
        }
        for(int i = 1; i < nums.length; i++){
            for(int j = target; j >= nums[i]; j--) {
                memo[j] = memo[j] || memo[j - nums[i]];
            }
        }
        return memo[target];
    }
}
