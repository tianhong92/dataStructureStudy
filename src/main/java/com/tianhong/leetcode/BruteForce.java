package com.tianhong.leetcode;

public class BruteForce {

    public static int bruteForce(String src, String sub) {
        int srcLength = src.length();
        int subLength = sub.length();
        int i = 0;
        int j = 0;
        while(i < srcLength && j < subLength) {
            if(src.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
            } else {
                i = i-j+1;
                j = 0;
            }
        }

        if(j == subLength) {
            return i-j;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        String sub = "test";
        String src = "hadtestsssss";
        System.out.println("index: " + bruteForce(src, sub));
    }
}
