package com.tianhong.leetcode.dynamicProgramming.LCSProblems;

// ABCDTHB  AEBDT  ===> 3
public class LongestCommonSubstring {
    public int getLCS(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0)
            return 0;
        return tryLCS(s1.toCharArray(), s2.toCharArray(), 0, 0);
    }

    public int tryLCS(char[] c1, char[] c2, int i, int j) {
        if(i == c1.length || j == c2.length)
            return 0;
        if(c1[i] == c2[j]) {
            return 1 + tryLCS(c1, c2, i + 1, j + 1);
        } else {
            return Integer.max(tryLCS(c1, c2, i + 1, j), tryLCS(c1, c2, i, j + 1));
        }
    }

    public static void main(String[] args) {
        String a = "ABCDTHB";
        String b = "AEBDHB";
        LongestCommonSubstring test = new LongestCommonSubstring();
        System.out.println(test.getLCS(a, b));
    }
}
