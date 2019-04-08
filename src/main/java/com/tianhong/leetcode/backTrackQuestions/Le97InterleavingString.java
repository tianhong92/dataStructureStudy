package com.tianhong.leetcode.backTrackQuestions;

import java.util.HashMap;
import java.util.Map;

public class Le97InterleavingString {
    public boolean is_Interleave(String s1, int i, String s2, int j, String s3) {
        if(s3.length() == 0 || (s1.length() + s2.length() != s3.length()))
            return false;
        return isInterleave(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0);
    }

    public boolean isInterleave(char[] s1, char[] s2, char[] s3, int i, int j){
        if(i + j == s3.length - 1)
            return true;
        boolean result = false;
        if(s1[i] == s3[i+j] && i + 1 < s1.length) {
            result = isInterleave(s1, s2, s3, i + 1, j);
        } else if (s2[j] == s3[i+j] && j + 1 < s2.length) {
            result = isInterleave(s1, s2, s3, i, j + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        Le97InterleavingString test = new Le97InterleavingString();
        boolean ret = test.is_Interleave(s1, 0, s3, 0, s2);
    }
}
