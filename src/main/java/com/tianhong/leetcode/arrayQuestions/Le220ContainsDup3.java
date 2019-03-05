package com.tianhong.leetcode.arrayQuestions;
// Given an array of integers, find out whether there are
// two distinct indices i and j in the array such that the absolute difference between nums[i] and
// nums[j] is at most t and the absolute difference between i and j is at most k.

// Input: nums = [1,2,3,1], k = 3, t = 0
// Output: true

// Input: nums = [1,0,1,1], k = 1, t = 2
// Output: true

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

// Input: nums = [1,5,9,1,5,9], k = 2, t = 3
// Output: false
public class Le220ContainsDup3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length < 2 || k < 1)
            return false;
        int l = 0;
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){

            Long a = set.floor((long)nums[i] + t);
            Long b = set.ceiling((long)nums[i] - t);
            if((a != null && a >= nums[i]) || (b != null && b <= nums[i]))
                return true;
            set.add((long)nums[i]);

            if(set.size() > k){
                set.remove((long)nums[l++]);
            }
        }
        return false;
    }



    public static void main(String[] args) {
        Le220ContainsDup3 test = new Le220ContainsDup3();
        int[] arr = new int[]{1, 2, 3, 1};
        test.containsNearbyAlmostDuplicate(arr, 3, 0);
    }
}
