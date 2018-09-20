package com.tianhong.leetcode.arrayQuestions;

import com.tianhong.DIYDataStructure.Stack.ArrayStack;

import java.util.Stack;

// Input: [1,1,0,1,1,1]
// Output: 3
// The input array will only contain 0 and 1.
public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int prev = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                count++;
            } else {
                if(count > prev)
                    prev = count;
                count = 0;
            }
        }
        return count > prev ? count : prev;
    }

    public static void main(String[] args) {
        int[] test = new int[]{ 1,0,1,1,1,0,1,1,1,1 };
        int ret = findMaxConsecutiveOnes(test);
        System.out.println(ret);
    }
}
