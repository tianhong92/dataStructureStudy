package com.tianhong.leetcode.arrayQuestions;

import java.util.Arrays;

public class Le268MissingNumber {
    // nlogn + n
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    // n
    public int missingNumber2(int[] nums) {
       boolean[] res = new boolean[nums.length + 1];
       int ret = 0;
       for(int i = 0; i < nums.length; i++) {
           res[nums[i]] = true;
       }
       for(int j = 0; j < res.length; j++) {
           if(!res[j]) {
               ret = j;
               break;
           }
       }
       return ret;
    }

    //
    public int missingNumber3(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return (nums.length * (nums.length + 1)) / 2 - sum;
    }
}
