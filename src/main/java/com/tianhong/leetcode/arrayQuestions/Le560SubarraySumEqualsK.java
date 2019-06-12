package com.tianhong.leetcode.arrayQuestions;

public class Le560SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                if(getSum(nums, i, j) == k){
                    count++;
                }
            }
        }
        return count;
    }


    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        int[] total = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            total[i] = getSum(nums, 0, i);
        }
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++){
                if(total[j] - total[i] + nums[i] == k)
                    count++;
            }
        }
        return count;
    }

    public int getSum(int[] nums, int i, int j) {
        int sum = 0;
        for(int k = i; k <= j; k++) {
            sum += nums[k];
        }
        return sum;
    }


}
