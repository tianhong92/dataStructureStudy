package com.tianhong.leetcode.Other;

public class Le553OptimalDivision {
        public String optimalDivision(int[] nums) {
            if(nums.length < 2)
                return String.valueOf(nums[0]);
            if(nums.length == 2)
                return String.valueOf(nums[0] + "/" + nums[1]);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < nums.length; i++) {
                if(i == 1) {
                    sb.append("(");
                    sb.append(nums[i]);
                    sb.append("/");
                } else if(i == nums.length - 1){
                    sb.append(nums[i]);
                    sb.append(")");
                } else {
                    sb.append(nums[i]);
                    sb.append("/");
                }
            }
            return sb.toString();
        }
}
