package com.tianhong.leetcode.dynamicProgramming.LISProblems;

public class Le376WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 1)
            return 0;
        //remove dups start from index 0
        int j = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]){
                j++;
            } else {
                break;
            }
        }
        int last = 0;
        int length = 1;
        int incr = 0;
        for(int k = j + 1; k < nums.length; k++) {
            if(incr == 0) {
                incr = nums[k] > nums[k - 1] ? 1 : -1;
                length++;
            } else if (incr == 1) {
                if(nums[k] < nums[k - 1]){
                    incr = -1;
                    length++;
                }
            } else {
                if(nums[k] > nums[k - 1]) {
                    incr = 1;
                    length++;
                }
            }
            last = nums[k];
        }
        return length;
    }
}
