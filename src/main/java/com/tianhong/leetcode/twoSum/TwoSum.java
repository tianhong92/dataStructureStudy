package com.tianhong.leetcode.twoSum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i  = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }else{
                map.put(nums[i], i);
            }
        }

        return new int[] {0, 0};
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 6, 7, 1};
        int[] result = twoSum(array, 9);
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
    }
}
