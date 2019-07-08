package com.tianhong.leetcode.backTrackQuestions;

public class Le45JumpGame2 {
    private int step;
    public int jump(int[] nums) {
        backTrack(nums, 0, 0);
        return step;
    }

    public void backTrack(int[] nums, int index, int count) {
        if(index == nums.length - 1) {
            if(step == 0 || count < step) {
                step = count;
            }
            return;
        }
        if(nums[index] == 0) {
            return;
        }
        for(int i= 1; i <= nums[index]; i++) {
            if(index + i < nums.length)
                backTrack(nums, index + i, count + 1);
        }
    }
}
