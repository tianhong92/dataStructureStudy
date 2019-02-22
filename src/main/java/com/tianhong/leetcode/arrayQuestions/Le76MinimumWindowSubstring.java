package com.tianhong.leetcode.arrayQuestions;

// Given a string S and a string T,
// find the minimum window in S which will contain all the characters in T in complexity O(n).

// Input: S = "ADOBECODEBANC", T = "ABC"
// Output: "BANC"

// If there is no such window in S that covers all characters in T, return the empty string "".
// If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

public class Le76MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s.length() ==0 || t.length() ==0 || s.length() < t.length()){
            return "";
        }
        int l = 0;
        int r = -1;
        int length = s.length() + 1;
        StringBuilder sb = new StringBuilder();
        String ret = "";

        int[] freq = new int[256];
        for(int i = 0; i < t.length(); i++){
            freq[(int)t.charAt(i)]++;
        }
        while(l < s.length()){
            int[] temp = freq.clone();
            if(r+1 < s.length() && (sb.length() < t.length() || !containAll(sb, temp, t.toCharArray()))){
                sb.append(s.toCharArray()[++r]);
            } else {
                sb.deleteCharAt(0);
                l++;
            }
            int[] temp2 = freq.clone();
            if(containAll(sb, temp2, t.toCharArray()) && sb.length() < length){
                length = sb.length();
                ret = sb.toString();
            }
        }
        return ret;
    }
    // check if String s contains all characters in int[] t
    public boolean containAll(StringBuilder s, int[] t, char[] p){
        for(int i = 0; i < s.length(); i++){
            t[(int)s.charAt(i)]--;
        }
        for(char c : p){
            if(t[(int)c] > 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "cabwefgewcwaefgcf";
        String p = "cae";
        Le76MinimumWindowSubstring test = new Le76MinimumWindowSubstring();
        String ret = test.minWindow(s, p);
        System.out.println(ret);
    }
}
