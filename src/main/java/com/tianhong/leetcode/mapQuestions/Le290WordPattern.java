package com.tianhong.leetcode.mapQuestions;
// Given a pattern and a string str, find if str follows the same pattern.
// Here follow means a full match, such that there is a bijection between
// a letter in pattern and a non-empty word in str.

// Input: pattern = "abba", str = "dog cat cat dog"
// Output: true
// Input: pattern = "aaaa", str = "dog cat cat dog"
// Output: false

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// Notes:
// You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
public class Le290WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if(pattern.length() == 0 || str.length() == 0){
            return false;
        }
        char[] chars = pattern.toCharArray();
        String[] strs = str.split(" ");
        if(chars.length != strs.length)
            return false;
        Map<Character, String> map = new HashMap<>();
        for(int i = 0; i < chars.length; i++){
            if(!map.containsKey(chars[i]) && !map.containsValue(strs[i])){
                map.put(chars[i], strs[i]);
            } else if (map.containsKey(chars[i])){
                if(!map.get(chars[i]).equals(strs[i])){
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Le290WordPattern test = new Le290WordPattern();
        System.out.println(test.wordPattern("jquery", "jquery"));
    }
}
