package com.tianhong.leetcode.arrayQuestions;

// Given nums = [-2, 0, 3, -5, 2, -1]
// sumRange(0, 2) -> 1
// sumRange(2, 5) -> -1
// sumRange(0, 5) -> -3
// 通过预处理
public class NumArray {
    private int[] sum; // sum[i] 前i个元素的和
    // sum[i]存储nums[0...i-1]的和
    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for(int i = 1; i < sum.length; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
