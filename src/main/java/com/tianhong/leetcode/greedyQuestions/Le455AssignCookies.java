package com.tianhong.leetcode.greedyQuestions;

import com.tianhong.DIYDataStructure.Array.Array;

import java.util.Arrays;

public class Le455AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length < 1 || g.length < 1)
            return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int ret = 0;
        int i = s.length - 1;
        int j = g.length - 1;
        while(i >= 0 && j >= 0) {
            if(s[i] >= g[j]) {
                i--;
                j--;
                ret++;
            } else {
                j--;
            }
        }
        return ret;
    }
}
