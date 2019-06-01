package com.tianhong.leetcode.greedyQuestions;

import java.util.Arrays;

// Given a string s and a string t, check if s is subsequence of t.
public class Le392IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        int i = s.length() - 1;
        int j = t.length() - 1;
        while(i >= 0 && j >= 0) {
            if(c2[j] == c1[i]) {
                j--;
                i--;
            } else {
                j--;
            }
        }
        return i < 0 ? true : false;
    }
}
