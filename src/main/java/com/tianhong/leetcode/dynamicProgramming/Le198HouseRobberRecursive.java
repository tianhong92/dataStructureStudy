package com.tianhong.leetcode.dynamicProgramming;

public class Le198HouseRobberRecursive {
    private int[] memo;
    public int rob(int[] nums) {
        if(nums.length < 1)
            return 0;
        // memo[index] 表示[0...index]范围最大值
        memo = new int[nums.length];
        memo[0] = nums[0];
        return tryRob(nums, nums.length - 1);
    }

    // 尝试抢劫 [0...index] 的房子
    public int tryRob(int[] nums, int index) {
        if(index < 0)
            return 0;
        if(memo[index] != 0)
            return memo[index];
        int res = 0;
        for(int i = index; i >= 0; i--){
            res = Math.max(res, nums[i] + tryRob(nums,i - 2));
        }
        memo[index] = res;
        return res;
    }

}
