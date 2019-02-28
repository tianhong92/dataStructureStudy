package com.tianhong.leetcode.mapQuestions;

// Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
// Find all unique triplets in the array which gives the sum of zero.
// Given array nums = [-1, 0, 1, 2, -1, -4],

import java.util.*;

//  A solution set is:
//  [
//      [-1, 0, 1],
//      [-1, -1, 2]
//  ]
public class Le15ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Set<List> set = new HashSet<>();
        if(nums.length < 3){
            return list;
        }
        Map<Integer, int[]> map = new HashMap<>();
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length - 3; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    if(set.add(temp)){
                        list.add(temp);
                    }
                }
                if(sum < 0){
                    j++;
                } else {
                    k--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Le15ThreeSum test = new Le15ThreeSum();


    }
}
