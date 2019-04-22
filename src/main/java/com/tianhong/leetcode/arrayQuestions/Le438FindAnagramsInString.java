package com.tianhong.leetcode.arrayQuestions;

// Input:
// s: "cbaebabacd" p: "abc"
// Output:
// [0, 6]


import java.util.ArrayList;
import java.util.List;

public class Le438FindAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(s.length() == 0 || p.length() == 0){
            return list;
        }

        int[] freq = new int[256];
        for(char c : p.toCharArray()){
            freq[(int)c]++;
        }

        int l = 0;
        int r = -1;
        while(l < s.length()){
            if(r+p.length() < s.length()){
               int[] tempFreq = freq.clone();
               if(isAnagramString(s.substring(l, r+p.length()+1), tempFreq)){
                   list.add(l);
               }
            }
            l++;
            r++;
        }
        return list;
    }

    public boolean isAnagramString(String a, int[] f){
        for(char c : a.toCharArray()){
            f[(int)c]--;
            if(f[(int)c] < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        Le438FindAnagramsInString test = new Le438FindAnagramsInString();
        List<Integer> ret = test.findAnagrams(s, p);
        for(int i : ret){
            System.out.println(i+" ");
        }

    }

}
