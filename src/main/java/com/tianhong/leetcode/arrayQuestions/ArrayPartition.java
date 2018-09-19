package com.tianhong.leetcode.arrayQuestions;

import java.util.Arrays;

// Input: [1,4,3,2]
// Output: 4
//Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
public class ArrayPartition {
    public int arrayPairSum(int[] nums){
        int sum = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i+=2){
            sum+=nums[i];
        }
        return sum;
    }
}
