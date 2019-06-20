package com.tianhong.leetcode.arrayQuestions;

import java.util.HashMap;
import java.util.Map;

public class Le1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ret = new int[2];
        for(int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if(map.containsKey(nums[i])) {
                ret[0] = map.get(another);
                ret[1] = i;
                break;
            } else {
                map.put(another, i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        Le1TwoSum test = new Le1TwoSum();
        int[] ret = test.twoSum(arr, 9);
        System.out.println(123);
    }
}
