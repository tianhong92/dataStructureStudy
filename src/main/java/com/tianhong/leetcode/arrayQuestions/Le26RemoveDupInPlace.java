package com.tianhong.leetcode.arrayQuestions;

public class Le26RemoveDupInPlace {
        public int removeDuplicates(int[] nums) {
            if(nums.length < 2)
                return nums.length;
            int i = 0, j = 1, count = 0;
            while(j < nums.length) {
                if(nums[i] == nums[j]) {
                    count++;
                    j++;
                } else {
                    i = j;
                    j++;
                }
            }
            return count;
        }
}
