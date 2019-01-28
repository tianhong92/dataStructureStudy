package com.tianhong.leetcode.arrayQuestions;

// Given an array of integers and an integer k,
// find out whether there are two distinct indices i and j in the array such
// that nums[i] = nums[j] and the absolute difference between i and j is at most k.

//Input: nums = [1,2,3,1], k = 3
//Output: true
//Example 2:
//
//Input: nums = [1,0,1,1], k = 1
//Output: true
//Example 3:
//
//Input: nums = [1,2,3,1,2,3], k = 2
//Output: false
public class Le219ContainsDup {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        return hasDup(nums, 0, k);
    }

    public static boolean hasDup(int[] array, int i, int k){
        int lastIndex = array.length - 1;
        if((i+k) > lastIndex ){
            return false;
        }
        if(array[i] == array[i+k]){
            return true;
        }
        return hasDup(array, i + 1, k);
    }

    public static void main(String[] args) {
        int[] test = { 1,0,1,1 };
        System.out.println(new Le219ContainsDup().containsNearbyDuplicate(test, 2));
    }
}
