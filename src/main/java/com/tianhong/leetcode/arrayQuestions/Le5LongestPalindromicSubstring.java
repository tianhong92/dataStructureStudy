package com.tianhong.leetcode.arrayQuestions;

public class Le5LongestPalindromicSubstring {
    String ret;
    public String longestPalindrome(String s) {
        ret = "";
        getMax(s);
        return ret;
    }

    public void getMax(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(ret.length() > s.length() - i) {
                continue;
            }
            for(int j = i; j <= s.length(); j++) {
                if(isPalindrome(s.substring(i, j)) && j - i > ret.length()) {
                    ret = s.substring(i, j);
                }
            }
        }
    }

    public boolean isPalindrome(String sub) {
        if(sub == "")
            return true;
        int i = 0, j = sub.length() - 1;
        while(i < j) {
            if(sub.charAt(i) != sub.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
