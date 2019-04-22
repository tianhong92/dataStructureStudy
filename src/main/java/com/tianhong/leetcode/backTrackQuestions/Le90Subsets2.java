package com.tianhong.leetcode.backTrackQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  Input: [1,2,2]
//  Output:
//  [
//      [2],
//      [1],
//      [1,2,2],
//      [2,2],
//      [1,2],
//      []
//  ]
public class Le90Subsets2 {
    private List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length < 1)
            return list;
        Arrays.sort(nums);
        backTrack(nums, new ArrayList<>(), 0);
        return list;
    }

    public void backTrack(int[] nums, List<Integer> temp, int start) {
        list.add(new ArrayList<>(temp));
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i - 1])
                continue;;
            if(temp.size() < nums.length) {
                temp.add(nums[i]);
                backTrack(nums, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
