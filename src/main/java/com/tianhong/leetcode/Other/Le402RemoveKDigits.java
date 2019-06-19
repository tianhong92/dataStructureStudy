package com.tianhong.leetcode.Other;

public class Le402RemoveKDigits {

    public String removeKdigits(String num, int k) {
         if(num.length() <= k)
             return "0";
         String ret = getMinimum(num.toCharArray(), new StringBuilder(), 0, num.length() - k);
         return ret.isEmpty() ? "0" : ret;
    }

    public String getMinimum(char[] nums, StringBuilder sb, int index, int size) {
        if(sb.length() == size || index >= nums.length) {
            return sb.toString();
        }
        char min = nums[index];
        int minIndex = index;
        for(int i = index; i <= nums.length - size + sb.length(); i++) {
            if(nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
        }
        if(min != '0' || sb.length() > 0)
            sb.append(min);
        return getMinimum(nums, sb, minIndex + 1, size);
    }

}
