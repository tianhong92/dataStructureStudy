package com.tianhong.leetcode.dynamicProgramming.LISProblems;

public class Le300LongestIncreaseSubsequence {
    private int[] memo;
    private boolean[] token;
    public int lengthOfLIS(int[] nums) {
        if(nums.length < 2)
            return nums.length;
        memo = new int[nums.length];
        token = new boolean[nums.length];
        for(int i = 0; i < memo.length; i++){
            memo[i] = 1;
        }
        getLIS(nums, nums.length - 1);
        int max = 1;
        for(int i : memo){
            if(i > max)
                max = i;
        }
        return max;
    }

    public int getLIS(int[] nums, int index) {
        if(token[index])
            return memo[index];
        int ret = 1;
        for(int i = 0; i < index; i++){
           int lis = getLIS(nums, i);
           if(nums[index] > nums[i]){
               ret = Integer.max(ret, lis + 1);
           }
        }
        memo[index] = ret;
        token[index] = true;
        return ret;
    }
}
