package com.tianhong.leetcode.dynamicProgramming;

public class Le416PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        return isEqual(nums, 0, 0, nums.length - 1);
    }

    public boolean isEqual(int[] nums, int left, int right, int index) {
        if(index >= nums.length || index < -1)
            return false;
        if(index == -1 && left == right)
            return true;
        boolean moveLeft = false;
        boolean moveRight = false;
        if (left <= right)
            moveLeft = isEqual(nums, left + nums[index], right, index - 1);
        else
            moveRight = isEqual(nums, left, right + nums[index], index - 1);
        return moveLeft || moveRight;
    }

    
}
