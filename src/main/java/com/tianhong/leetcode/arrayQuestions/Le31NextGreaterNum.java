package com.tianhong.leetcode.arrayQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Le31NextGreaterNum {
    public void nextPermutation(int[] nums) {
        if(nums.length < 2)
            return;
        int loc = 0;
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] > nums[i + 1]) {
                loc = i;
                break;
            }
        }
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] > nums[loc]) {
                swap(nums, i, loc);
            }
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
