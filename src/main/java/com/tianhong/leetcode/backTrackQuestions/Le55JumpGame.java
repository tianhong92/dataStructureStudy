package com.tianhong.leetcode.backTrackQuestions;

public class Le55JumpGame {
    private int[] memo;

    public boolean canJump(int[] nums) {
        memo = new int[nums.length];
        return tryJump(nums, 0);
    }

    public boolean tryJump(int[] nums, int index) {
        if(memo[index] == 1) {
            return false;
        }
        if(index == nums.length - 1) {
            return true;
        }
        if(index >= nums.length || nums[index] == 0) {
            return false;
        }
        for(int i = 1; i <= nums[index]; i++) {
            if(tryJump(nums, index + i)){
                return true;
            }
        }
        memo[index] = 1;
        return false;
    }
}
