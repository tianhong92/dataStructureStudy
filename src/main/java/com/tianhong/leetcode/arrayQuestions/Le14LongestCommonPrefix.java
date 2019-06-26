package com.tianhong.leetcode.arrayQuestions;

public class Le14LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length < 1)
            return "";
        int size = Integer.MAX_VALUE;
        int loc = 0;
        for(int i = 0; i < strs.length; i++) {
            if(strs[i].length() < size) {
                size = strs[i].length();
                loc = i;
            }
        }
        if(strs[loc].length() < 1)
            return "";

        for(int i = 1; i <= strs[loc].length(); i++) {
            String temp = strs[loc].substring(0, i);
            for(int j = 0; j < strs.length; j++) {
                if(j != loc) {
                    String next = strs[j];
                    if (next.length() < temp.length() || !next.substring(0, i).equals(temp)) {
                        return temp.substring(0, temp.length() - 1);
                    }
                }
            }
        }
        return strs[loc];
    }

    public static void main(String[] args) {
        String a = "abc";
        String b = "bcdefgabd";
        System.out.println(b.indexOf(a));
    }
}
