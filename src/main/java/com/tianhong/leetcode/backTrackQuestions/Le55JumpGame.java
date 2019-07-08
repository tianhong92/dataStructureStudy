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

    private boolean[] canReach;
    public boolean canJump2(int[] nums) {
        if(nums.length < 2)
            return true;
        canReach = new boolean[nums.length];
        canReach[0] = true;


        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(canReach[j] && nums[j] >= (i - j)) {
                    canReach[i] = true;
                    break;
                }
            }
            if(!canReach[i]) {
                return false;
            }
        }
        return canReach[nums.length - 1];
    }


}
