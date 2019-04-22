package com.tianhong.leetcode.mapQuestions;

import java.util.*;

// Given an array of strings, group anagrams together.
//  Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//  Output:
//  [
//      ["ate","eat","tea"],
//      ["nat","tan"],
//      ["bat"]
//  ]
// All inputs will be in lowercase.
// The order of your output does not matter.
public class Le49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        if(strs.length < 1)
            return list;
        Map<Set, List> map = new HashMap<>();
        int[] ascii = new int[256];
        for(int i = 0; i < strs.length; i++){
            String str = strs[i];
            Set<Integer> set = new HashSet<>();
            for(char c : str.toCharArray()){
                set.add(c - 'a');
            }
            if(map.containsKey(set)){
                List tempList = map.get(set);
                tempList.add(strs[i]);
            } else {
                List tempList = new ArrayList();
                tempList.add(strs[i]);
                map.put(set, tempList);
            }
        }

        for(Map.Entry entry : map.entrySet()){
            list.add((List<String>) entry.getValue());
        }
        return list;
    }

    public static void main(String[] args) {
        Le49GroupAnagrams test = new Le49GroupAnagrams();
        String[] str = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ret = test.groupAnagrams(str);
        System.out.println(ret.size());
    }
}
