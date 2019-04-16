package com.tianhong.leetcode.backTrackQuestions;

// Input: candidates = [10,1,2,7,6,1,5], target = 8,
//A solution set is:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]

// Each number in candidates may only be used once in the combination.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Le40CombinationSum2 {
    private List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(target < 1) {
            return list;
        }
        Arrays.sort(candidates);
        backTrack(candidates, target, new ArrayList<>(), 0, 0);
        return list;
    }

    public void backTrack(int[] cans, int target, List<Integer> temp, int sum, int start) {
        if(sum == target) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start; i < cans.length; i++) {
            if(sum + cans[i] <= target) {
                temp.add(cans[i]);
                backTrack(cans, target, temp, sum + cans[i], i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3};
        System.out.println(arr[-1]);
    }
}
