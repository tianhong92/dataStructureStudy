package com.tianhong.leetcode.backTrackQuestions;

import java.util.ArrayList;
import java.util.List;

// 回溯解决排列问题
//  Input: [1,2,3]
//  Output:
//  [
//      [1,2,3],
//      [1,3,2],
//      [2,1,3],
//      [2,3,1],
//      [3,1,2],
//      [3,2,1]
//  ]
public class Le46Permutations {
    private List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length <= 1)
            return list;
        backTrack(nums, 0, new ArrayList<Integer>());
        return list;
    }

    public void backTrack(int[] nums, int index, List<Integer> l) {
        if(index == nums.length) {
            list.add(new ArrayList<>(l));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!l.contains(nums[i])){
                l.add(nums[i]);
                backTrack(nums, index + 1, l);
                l.remove(l.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3};
        Le46Permutations test = new Le46Permutations();
        test.permute(arr);
    }

}
