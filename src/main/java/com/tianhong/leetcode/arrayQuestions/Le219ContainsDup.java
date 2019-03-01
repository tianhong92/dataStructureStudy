package com.tianhong.leetcode.arrayQuestions;

// Given an array of integers and an integer k,
// find out whether there are two distinct indices i and j in the array such
// that nums[i] = nums[j] and the absolute difference between i and j is at most k.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if(nums == null || nums.length < 2)
            return false;
        Map<Integer, List> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                List<Integer> temp =  map.get(nums[i]);
                for(int j : temp){
                    if(Math.abs(i - j) <= k){
                        return true;
                    }
                }
                temp.add(i);
            } else {
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                map.put(nums[i], newList);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] test = { 1, 2, 3, 1, 2, 3 };
        System.out.println(new Le219ContainsDup().containsNearbyDuplicate2(test, 2));
    }
}
