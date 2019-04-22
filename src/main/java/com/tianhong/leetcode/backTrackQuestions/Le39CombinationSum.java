package com.tianhong.leetcode.backTrackQuestions;


import java.util.*;
// find all unique combinations in candidates where the candidate numbers sums to target.
// Input: candidates = [2,3,6,7], target = 7,
// A solution set is:
// [
//   [7],
//   [2,2,3]
// ]

public class Le39CombinationSum {

    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(target < 1)
            return list;
        Arrays.sort(candidates);
        backTrack(candidates, new ArrayList<>(), target, 0, 0);
        return list;
    }

    public void backTrack(int[] cans, List<Integer> temp, int target, int sum, int start) {
        if(sum == target) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start; i < cans.length; i++) {
            if(i > start && cans[i] == cans[i-1])
                continue;
            if(sum + cans[i] <= target) {
                temp.add(cans[i]);
                backTrack(cans, temp, target, sum + cans[i], i);
                temp.remove(temp.size() - 1);
            } else {
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] ar = new int[]{2, 2, 3, 6, 7};
        Le39CombinationSum test = new Le39CombinationSum();
        test.combinationSum(ar, 7);
        System.out.println(12);
    }

}
