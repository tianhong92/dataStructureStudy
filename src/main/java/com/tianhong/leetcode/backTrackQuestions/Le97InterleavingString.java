package com.tianhong.leetcode.backTrackQuestions;

import java.util.HashMap;
import java.util.Map;

public class Le97InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() == 0 || (s1.length() + s2.length() != s3.length()))
            return false;
        return isInterleave1(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0);
    }

    public boolean isInterleave1(char[] s1, char[] s2, char[] s3, int i, int j){
        if(i + j == s3.length)
            return true;
        return i < s1.length && s1[i] == s3[i+j] && isInterleave1(s1, s2, s3, i+1, j)
                || j < s2.length && s2[j] == s3[i+j] && isInterleave1(s1, s2, s3, i, j+1);

    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        Le97InterleavingString test = new Le97InterleavingString();
        boolean ret = test.isInterleave(s1, s3, s2);
    }
}
