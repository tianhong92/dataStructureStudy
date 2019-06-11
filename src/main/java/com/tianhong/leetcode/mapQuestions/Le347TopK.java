package com.tianhong.leetcode.mapQuestions;

import java.util.*;

public class Le347TopK {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        List[] list = new ArrayList[nums.length + 1];
        for(int i : map.keySet()) {
            int count = map.get(i);
            if(list[count] == null)
                list[count] = new ArrayList<>();
            list[count].add(i);
        }
        List<Integer> ret = new ArrayList<>();
        for(int i = list.length - 1; i >= 0; i--) {
            if(k > 0 && list[i].size() > 0) {
                ret.addAll(list[i]);
                k -= list[i].size();
            }
        }
        return ret;
    }

}
