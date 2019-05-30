package com.tianhong.leetcode.dynamicProgramming;

public class Le494TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length < 1 || S < 1)
            return 0;
        return countWays(nums, S, 0, 0);
    }

    public int countWays(int[] nums, int S, int total, int index) {
        if(index == nums.length){
            if(S == total)
                return 1;
            else
                return 0;
        }
        return countWays(nums, S, total + nums[index], index + 1) + countWays(nums, S, total - nums[index], index + 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1000};
        Le494TargetSum test = new Le494TargetSum();
        int ret = test.findTargetSumWays(arr, -1000);
        System.out.println(ret);
    }
}
