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

    public int rob2(int[] nums) {
        int oneStepBackMax = 0;
        int twoStepBackMax = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i] + twoStepBackMax, oneStepBackMax);
            oneStepBackMax = max;
            twoStepBackMax = oneStepBackMax;
        }
        return max;
    }

    public int rob3(int[] nums) {
        int oneStepBackMax1 = 0;
        int twoStepBackMax1 = 0;
        int oneStepBackMax2 = 0;
        int twoStepBackMax2 = 0;
        int max1 = 0;
        int max2 = 0;
        for(int i = 0; i < nums.length; i++) {
            max1 = Math.max(nums[i] + twoStepBackMax1, oneStepBackMax1);
            oneStepBackMax1 = max1;
            twoStepBackMax1 = oneStepBackMax1;
        }
//        for(int j = 1; j < nums.length; j++) {
//            max2 = Math.max(nums[j] + twoStepBackMax2, oneStepBackMax2);
//            oneStepBackMax2 = max2;
//            twoStepBackMax2 = oneStepBackMax2;
//        }
//        return Math.max(max1, max2);
        return max1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, 3, 2};
        Le198HouseRobber test = new Le198HouseRobber();
        int ret = test.rob2(arr);
        System.out.println(ret);
    }
}
