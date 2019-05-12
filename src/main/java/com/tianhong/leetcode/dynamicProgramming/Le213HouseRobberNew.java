package com.tianhong.leetcode.dynamicProgramming;

public class Le213HouseRobberNew {
    public int rob(int[] nums) {
        int max1 = 0;
        int oneStepBackMax = 0;
        int twoStepBackMax = 0;
        //[0...nums.length - 2] 能抢劫的最大值
        for(int i = 0; i < nums.length - 1; i++) {
            max1 = Math.max(nums[i] + twoStepBackMax, oneStepBackMax);
            twoStepBackMax = oneStepBackMax;
            oneStepBackMax = max1;
        }

        int max2 = 0;
        int oneStepBackMax1 = 0;
        int twoStepBackMax1 = 0;
        for(int i = 1; i < nums.length; i++) {
            max2 = Math.max(nums[i] + twoStepBackMax1, oneStepBackMax1);
            twoStepBackMax1 = oneStepBackMax1;
            oneStepBackMax1 = max2;
        }
        int e = 0;
        return Math.max(max1, max2);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 2, 7};
        Le213HouseRobberNew test = new Le213HouseRobberNew();
        test.rob(arr);
    }

}
