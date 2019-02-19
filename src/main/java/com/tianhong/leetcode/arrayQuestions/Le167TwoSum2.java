package com.tianhong.leetcode.arrayQuestions;
// Given an array of integers that is already sorted in ascending order,
// find two numbers such that they add up to a specific target number.
//
// The function twoSum should return indices of the two numbers such that
// they add up to the target, where index1 must be less than index2.
//
// Note: Your returned answers (both index1 and index2) are not zero-based.
// You may assume that each input would have exactly one solution and you may not use the same element twice.

import java.util.ArrayList;
import java.util.List;

// Input: numbers = [2,7,11,15], target = 9
// Output: [1,2]
public class Le167TwoSum2 {
    public int[] twoSum1(int[] numbers, int target) {
        int[] index = new int[2];
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < numbers.length; i++){
            if(list.contains(numbers[i])){
                index[0] = list.indexOf(numbers[i])+1;
                index[1] = i+1;
                return index;
            } else {
                list.add(target - numbers[i]);
            }
        }
        return index;
    }
}
