package com.tianhong.leetcode.mapQuestions;

// Given two strings s and t , write a function to determine if t is an anagram of s.
// Input: s = "anagram", t = "nagaram"
// Output: true
// Input: s = "rat", t = "car"
// Output: false

import com.tianhong.DIYDataStructure.Array.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Le242ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : chars1){
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for(char c1 : chars2){
            if(!map.containsKey(c1)){
                return false;
            } else {
                if(map.get(c1) < 1){
                    return false;
                } else {
                    map.put(c1, map.get(c1) - 1);
                }
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }


}
