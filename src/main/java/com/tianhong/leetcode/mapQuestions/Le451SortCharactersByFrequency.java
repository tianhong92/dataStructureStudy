package com.tianhong.leetcode.mapQuestions;

import java.util.*;

// Given a string, sort it in decreasing order based on the frequency of characters.
// Input:
//"tree"
//
//Output:
//"eert"
//
//Explanation:
//'e' appears twice while 'r' and 't' both appear once.
//So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
public class Le451SortCharactersByFrequency {
    public String frequencySort(String s) {
       Map<Character, Integer> map = new HashMap<>();
       for(char c : s.toCharArray()){
           map.put(c, map.getOrDefault(c, 0) + 1);
       }
       List<Character> [] bucket = new ArrayList[s.length() + 1];
       for(char key : map.keySet()){
           int frequency = map.get(key);
           if(bucket[frequency] == null){
               bucket[frequency] = new ArrayList<>();
           }
           bucket[frequency].add(key);
       }
       StringBuilder sb = new StringBuilder();
       for(int i = bucket.length - 1; i >= 0; i--){
            if(bucket[i] != null){
                for(char c : bucket[i]){
                    for(int j = 0; j < map.get(c); j++){
                        sb.append(c);
                    }
                }
            }
       }
       return sb.toString();
    }

    // use PriorityQueue
    public String frequencySort2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        //pq.addAll(map.entrySet());
        for(Map.Entry<Character, Integer> en : map.entrySet()){
            pq.add(en);
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry e = pq.poll();
            for(int i = 0; i < (int)e.getValue(); i++){
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        Le451SortCharactersByFrequency test = new Le451SortCharactersByFrequency();
        String ret = test.frequencySort2(s);
        System.out.println(ret);

    }
}
