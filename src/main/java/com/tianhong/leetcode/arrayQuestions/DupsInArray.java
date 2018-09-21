package com.tianhong.leetcode.arrayQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

// Input:
// [4,3,2,7,8,2,3,1]
// Output:
// [2,3]
// Find all the elements that appear twice in this array.
// 1 <= a[i] <= n (n = size of array)
public class DupsInArray {
    // 把数组看成hash
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[Math.abs(nums[i])-1] < 0){
                list.add(Math.abs(nums[i]));
            } else {
                nums[Math.abs(nums[i])-1] = nums[Math.abs(nums[i])-1] - 2*nums[Math.abs(nums[i])-1];
            }
        }
        return list;
    }
}
