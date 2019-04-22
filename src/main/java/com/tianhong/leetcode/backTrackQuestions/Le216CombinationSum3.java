package com.tianhong.leetcode.backTrackQuestions;

import java.util.ArrayList;
import java.util.List;

// Input: k = 3, n = 7
// Output: [[1,2,4]]

// Input: k = 3, n = 9
// Output: [[1,2,6], [1,3,5], [2,3,4]]
public class Le216CombinationSum3 {
    private List<List<Integer>> list = new ArrayList<>();
    private int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k < 1 || n < 1)
            return list;

        backTrack(k, n, 0, 0, nums, 0, new ArrayList<>());
        return list;
    }

    public void backTrack(int k, int n, int level, int sum, int[] nums, int start, List<Integer> temp) {
        if(level == k && sum == n) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1])
                continue;
            if(sum + nums[i] <= n && level < k) {
                temp.add(nums[i]);
                backTrack(k, n, level + 1, sum + nums[i], nums, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
