package com.tianhong.leetcode.stringQuestions;

public class Le28ImplementStr {
    public int strStr(String haystack, String needle) {
        if(needle == "" || haystack == "")
            return 0;
        int i = 0;
        int size = needle.length();
        int ret = -1;
        while(i <= haystack.length()) {
            if(haystack.charAt(i) != needle.charAt(0)){
                i++;
            } else {
                if(i + size <= haystack.length()) {
                    String hay = haystack.substring(i, i + size);
                    if(hay.equals(needle)){
                        ret = i;
                    }
                } else {
                    break;
                }
            }
        }
        return i;
    }
}
