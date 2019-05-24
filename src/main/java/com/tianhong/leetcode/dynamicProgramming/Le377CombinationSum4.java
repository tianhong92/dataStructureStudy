package com.tianhong.leetcode.dynamicProgramming;

import java.util.Arrays;

// nums = [1, 2, 3]
// target = 4
// The possible combination ways are:
// (1, 1, 1, 1)
// (1, 1, 2)
// (1, 2, 1)
// (1, 3)
// (2, 1, 1)
// (2, 2)
// (3, 1)
// Note that different sequences are counted as different combinations.
public class Le377CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
       if(target == 0)
           return 0;
       if(nums.length < 1 || target < 0)
           return 0;
       int[] memo = new int[target + 1];
       for(int i = 0; i <= target; i++) {
           if(i % nums[0] == 0)
               memo[i] = 1;
       }

       for(int i = 1; i < nums.length; i++) {
           for(int j = 1; j <= target; j++) {
               int res = 0;
               for(int k = 0; k <= i; k++) {
                   if(j >= nums[k])
                       res += memo[j - nums[k]];
               }
               memo[j] = res;
           }
       }
       return memo[target];
    }
}
