package com.tianhong.leetcode.dynamicProgramming;

public class Le213HouseRobber2 {

    public int rob(int[] nums) {
        if(nums.length < 1)
            return 0;
        if(nums.length == 1)
            return nums[0];
        return Math.max(tryRob(nums, 0, nums.length - 2, new int[nums.length]),
                tryRob(nums, 1, nums.length - 1, new int[nums.length]));
    }

    // 尝试抢劫[index1...index2]的房子
    public int tryRob(int[] nums, int index1, int index2, int[] memo) {
        if(index1 > index2)
            return 0;
        if(memo[index1] != 0)
            return memo[index1];
        int res = 0;
        for(int i = index1; i <= index2; i++) {
            res = Math.max(res, nums[i] + tryRob(nums, i + 2, index2, memo));
        }
        memo[index1] = res;
        return res;
    }

}
