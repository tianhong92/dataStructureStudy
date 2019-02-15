package com.tianhong.leetcode.stringQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author TianhongWang
 * @since 2019/2/15
 */

// Longest Substring Without Repeating Characters
// Given a string, find the length of the longest substring without repeating characters.
// Input: "abcabcbb"
// Output: 3

public class Le3LongestSub {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1){
            return s.length();
        }
        char[] chars = s.toCharArray();
        int size = 0;
        List<Character> temp = new LinkedList<>();
        for(int i = 0; i < chars.length; i++){
            for(int j = i; j < chars.length; j++){
                if(!temp.contains(chars[j])){
                    temp.add(chars[j]);
                    if(temp.size() > size){
                        size = temp.size();
                    }
                } else {
                    temp.clear();
                    temp.add(chars[j]);
                }
            }
            temp.clear();
        }
        return size;
    }


    // using Brute Force, check all subStrings and update the size
    public int solution1(String s){
        if(s.length() <= 1){
            return s.length();
        }
        int size = 1;
        char[] chars = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            for(int j = i + 1; j < s.length(); j++){
                if(uniqueCheck(chars, i, j) && ((j - i + 1) > size)){
                    size = j - i + 1;
                }
            }
        }
        return size;
    }

    private boolean uniqueCheck(char[] s, int start, int end){
        HashSet<Character> set = new HashSet<>();
        for(int i = start; i <= end; i++){
            Character c = s[i];
            if(set.contains(c)){
                return false;
            } else {
                set.add(c);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Le3LongestSub test = new Le3LongestSub();
        int ret = test.solution1("asjrgapa");
        System.out.println(ret);
    }
}
