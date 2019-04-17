package com.tianhong.leetcode.backTrackQuestions;

import java.util.ArrayList;
import java.util.List;
// Given a set of distinct integers, nums, return all possible subsets (the power set).
//  Input: nums = [1,2,3]
//  Output:
//  [
//      [3],
//      [1],
//      [2],
//      [1,2,3],
//      [1,3],
//      [2,3],
//      [1,2],
//      []
//  ]

public class Le78Subsets {
    private List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length < 1)
            return list;
        backTrack(nums, 0, new ArrayList<>());
        return list;
    }

    public void backTrack(int[] nums, int start, List<Integer> temp) {
        list.add(new ArrayList<>(temp));

        for(int i = start; i < nums.length; i ++) {
           if(temp.size() < nums.length) {
               temp.add(nums[i]);
               backTrack(nums, i + 1, temp);
               temp.remove(temp.size() - 1);
           }
        }
    }
}
