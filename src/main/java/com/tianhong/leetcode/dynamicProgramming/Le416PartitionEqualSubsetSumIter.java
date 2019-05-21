package com.tianhong.leetcode.dynamicProgramming;

public class Le416PartitionEqualSubsetSumIter {
    private boolean[][] memo;
    public boolean canPartition(int[] nums) {
        if(nums.length < 2)
            return false;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0)
            return false;
        memo = new boolean[nums.length][sum/2 + 1];
        return tryPartition(nums, nums.length - 1, sum/2);
    }

    // 使用[0...index]区域元素能否填满sum
    public boolean tryPartition(int[] nums, int index, int sum){
        if(index < 0 || sum < 0)
            return false;
        if(sum == 0)
            return true;
        if(memo[index][sum])
            return true;
        return memo[index][sum] = tryPartition(nums, index - 1, sum - nums[index]) ||
                tryPartition(nums, index - 1, sum);
    }
}
