package com.tianhong.leetcode.dynamicProgramming;

// m 0s and n 1s
public class Le474OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        if(m < 0 && n < 0)
            return 0;
        return getMax(strs, m, n, 0);
    }

    public int getMax(String[] strs, int m, int n, int index) {
        if(index > strs.length - 1)
            return 0;
        char[] chars = strs[index].toCharArray();
        int zeros = 0;
        int ones = 0;
        for(char c : chars) {
            if(c == '0')
                zeros++;
            else
                ones++;
        }
        int max = getMax(strs, m, n, index + 1);
        if(m >= zeros && n >= ones){
            max = Math.max(max, 1 + getMax(strs, m - zeros, n - ones, index + 1));
        }
        return max;
    }
}
