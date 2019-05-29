package com.tianhong.leetcode.dynamicProgramming;

public class Le494TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length < 1 || S < 1)
            return 0;
        return countWays(nums, S, 0, 0);
    }

    public int countWays(int[] nums, int S, int total, int index) {
        if(index == nums.length - 1){
            if(S == total)
                return 1;
            else
                return 0;
        }
        return countWays(nums, S, total + nums[index], index + 1) + countWays(nums, S, total - nums[index], index + 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 1, 1};
        Le494TargetSum test = new Le494TargetSum();
        test.findTargetSumWays(arr, 3);
    }
}
