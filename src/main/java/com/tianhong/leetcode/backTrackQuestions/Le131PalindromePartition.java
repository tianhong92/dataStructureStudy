package com.tianhong.leetcode.backTrackQuestions;

// todo
//  Input: "aab"
//  Output:
//  [
//      ["aa","b"],
//      ["a","a","b"]
//  ]

import java.util.ArrayList;
import java.util.List;

public class Le131PalindromePartition {
    List<List<String>> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s == null || s == "")
            return list;
        backTrack(new ArrayList<>(), 0, s);
        return list;
    }

    public void backTrack(List<String> l, int start, String s) {
        if(start == s.length()) {
            list.add(new ArrayList<>(l));
            return;
        }

        for(int i = start; i <= s.length(); i++) {
            if(isPalindrom(s.substring(start, i))) {
                l.add(s.substring(start, i));
                backTrack(l, i + 1, s);
                l.remove(l.size() - 1);
            }
        }
    }

    public boolean isPalindrom(String s) {
        if(s == null || s.equals(""))
            return false;
        if(s.length() == 1)
            return true;
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "aab";
        Le131PalindromePartition test = new Le131PalindromePartition();
        test.partition(str);
        System.out.println("gg");
    }
}
