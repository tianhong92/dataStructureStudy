package com.tianhong.leetcode.backTrackQuestions;

// Given a collection of distinct integers, return all possible permutations.
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

import java.util.ArrayList;
import java.util.List;

public class Le46Permutation {

    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0)
            return  ret;
        if(nums.length == 1){
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            ret.add(list);
            return ret;
        }
        backTrack(nums, new ArrayList<>(), new boolean[nums.length]);
        return ret;
    }

    public void backTrack(int[] nums, List<Integer> list, boolean[] used){
        if(list.size() == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < used.length; j++) {
                used[j] = false;
                temp.add(list.remove(0));
            }
            ret.add(temp);
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                backTrack(nums, list, used);
                System.out.println("hehe");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        Le46Permutation test = new Le46Permutation();
        List<List<Integer>> ret = test.permute(arr);
    }

}
