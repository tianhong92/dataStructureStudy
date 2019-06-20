package com.tianhong.leetcode.arrayQuestions;

import java.util.Arrays;
import java.util.Comparator;

public class Le179LargestNumber {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        String[] s = new String[len];
        for(int i = 0; i < len; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String temp1 = o1 + o2;
                String temp2 = o2 + o1;
                return temp2.compareTo(temp1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String s1 : s) {
            sb.append(s1);
        }
        if(sb.charAt(0) == '0')
            return "0";
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf("00"));
    }
}
