package com.tianhong.leetcode.arrayQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author TianhongWang
 * @since 2019/2/13
 */

// Given a set of distinct integers, nums, return all possible subsets (the power set).
// Note: The solution set must not contain duplicate subsets.
// Input: nums = [1,2,3]
// Output:
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]


public class Le78Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3};
        List<List<Integer>> ret = new Le78Subset().subsets(test);
        System.out.println("size: "+ret.size());
        for(int i = 0; i < ret.size(); i++){
            List<Integer> temp = ret.get(i);
            for(int j : temp){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
