package com.tianhong.leetcode.arrayQuestions;

import java.util.*;

// Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array)
// Find all the elements of [1, n] inclusive that do not appear in this array.
// Input:
// [4,3,2,7,8,2,3,1]
// Output:
// [5,6]
// do it without extra space and in O(n) runtime? the returned list does not count as extra space.
public class DisappearedNums448 {
    // Solution 1: set, but too costly
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new LinkedList<>();
        for(int i : nums)
            set.add(i);
        for(int j = 1; j <= nums.length; j++){
            if(!set.contains(j))
                list.add(j);
        }
        return list;
    }

    // Solution 2: 如果nums[nums[i] - 1]赋值为负数
    public List<Integer> findDisappearedNumbers2(int[] nums){
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[Math.abs(nums[i])-1] > 0)
                nums[Math.abs(nums[i])-1] = nums[Math.abs(nums[i])-1] - 2*nums[Math.abs(nums[i])-1];
        }
        for(int j = 0; j < nums.length; j++){
            if(nums[j] > 0)
                list.add(j+1);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        DisappearedNums448 test = new DisappearedNums448();
        test.findDisappearedNumbers2(nums);
    }
}
