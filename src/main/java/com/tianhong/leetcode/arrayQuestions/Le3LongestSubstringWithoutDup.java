package com.tianhong.leetcode.arrayQuestions;

import java.util.ArrayList;
import java.util.List;

// Given a string, find the length of the longest substring without repeating characters.
// Input: "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
public class Le3LongestSubstringWithoutDup {
    //滑动窗口法
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        char[] chars = s.toCharArray();
        if(chars.length <= 1){
            return chars.length;
        }

        int l = 0, r = 0; // [l, r]
        int length = 1;
        List<Character> list = new ArrayList<Character>();
        list.add(chars[l]);
        freq[(int)chars[l]]++;
        while(l < chars.length && r < chars.length){
            if(r+1 < chars.length && freq[(int)chars[r+1]] == 0){
                list.add(chars[++r]);
                freq[(int)chars[r]] = 1;
            } else {
                list.remove(0);
                freq[(int)chars[l]] = 0;
                l++;
            }
            if(list.size() > length){
                length = list.size();
            }
        }
        return length;
    }

    public static void main(String[] args) {
        String str = "abbbbcdeef";
        Le3LongestSubstringWithoutDup test = new Le3LongestSubstringWithoutDup();
        int ret = test.lengthOfLongestSubstring(str);
        System.out.println(ret);
    }
}
