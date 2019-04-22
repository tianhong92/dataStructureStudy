package com.tianhong.leetcode.arrayQuestions;

// Given an array of integers, find if the array contains any duplicates.
// Your function should return true if any value appears at least twice in the array,
// and it should return false if every element is distinct.

// Input: [1,2,3,1]
// Output: true

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Input: [1,2,3,4]
// Output: false
public class Le217ContainsDup {
    // Hash table
    public boolean containsDuplicate(int[] nums) {
        if(nums.length <= 1)
            return false;
        Set<Integer>  set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }

    // Sorting
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i+1])
                return true;
        }
        return false;
    }


}
