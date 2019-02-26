package com.tianhong.leetcode.mapQuestions;

import java.util.HashMap;
import java.util.Map;

// Input: s = "egg", t = "add"
// Output: true
// Input: s = "foo", t = "bar"
// Output: false
// Input: s = "paper", t = "title"
// Output: true
// Note:
//You may assume both s and t have the same length.
public class Le205IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() == 0 && t.length() == 0){
            return true;
        }

        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Map<Character, Character> map = new HashMap<>();

        for(int i = 0; i < c1.length; i++){
            if(!map.containsKey(c1[i]) && !map.containsValue(c2[i])){
                map.put(c1[i], c2[i]);
            } else if(map.containsKey(c1[i])){
                if(map.get(c1[i]) != c2[i]){
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
