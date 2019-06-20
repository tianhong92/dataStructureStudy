package com.tianhong.leetcode.arrayQuestions;

public class Le136SingleNum {
    // A ^ B ^ C = A ^ C ^ B
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
