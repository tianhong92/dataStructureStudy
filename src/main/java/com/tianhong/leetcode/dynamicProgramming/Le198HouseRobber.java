package com.tianhong.leetcode.dynamicProgramming;

/**
 * @author TianhongWang
 * @since 2019/5/8
 */
public class Le198HouseRobber {
    private int[] memo;
    public int rob(int[] nums) {
        if(nums.length < 1)
            return 0;
        memo = new int[nums.length];
        return tryRob(0, nums);
    }

    // 考虑抢劫[index...nums.length]范围内的房子
    public int tryRob(int index, int[] nums){
        int res = 0;
        if(memo[index] != 0)
            return memo[index];
        if(index >= nums.length)
            return 0;
        for(int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + tryRob(i + 2, nums));
        }
        memo[index] = res;
        return res;
    }
}
