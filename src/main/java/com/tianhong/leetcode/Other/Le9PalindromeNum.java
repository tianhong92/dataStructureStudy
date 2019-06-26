package com.tianhong.leetcode.Other;

public class Le9PalindromeNum {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        String s = String.valueOf(x);
        int length = s.length();
        int i = 0;
        int j = length - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
