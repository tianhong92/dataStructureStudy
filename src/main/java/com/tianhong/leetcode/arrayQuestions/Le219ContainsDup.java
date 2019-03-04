package com.tianhong.leetcode.arrayQuestions;

// Given an array of integers and an integer k,
// find out whether there are two distinct indices i and j in the array such
// that nums[i] = nums[j] and the absolute difference between i and j is at most k.

import java.util.*;

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
        if(nums == null || nums.length < 2 || nums.length < k + 1)
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

    // 利用滑动窗口
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if(nums.length < 2 || k < 1){
            return false;
        }
        int l = 0;
        int r = l + k;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i <= r; i++) {
            if(!set.add(nums[i])){
                return true;
            }
        }

        while(r < nums.length - 1){
            set.remove(nums[l++]);
            if(!set.add(nums[++r])){
                return true;
            }
        }
        return false;
    }

    // 利用滑动窗口
    public boolean containsNearbyDuplicate3(int[] nums, int k) {
        if(nums.length < 2 || k < 1)
            return false;

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!set.add(nums[i]))
                return true;
            if(set.size() == k + 1){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test = { 1, 2, 3, 1, 3, 3 };
        System.out.println(new Le219ContainsDup().containsNearbyDuplicate(test, 2));
    }
}
