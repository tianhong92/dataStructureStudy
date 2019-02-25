package com.tianhong.leetcode.mapQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Given two arrays, write a function to compute their intersection.
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2,2]
// Each element in the result should appear as many times as it shows in both arrays.
// The result can be in any order.
public class Le350IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++){
            if(!map.containsKey(nums1[i])){
                map.put(nums1[i], 1);
            } else {
                map.put(nums1[i], map.get(nums1[i])+1);
            }
        }
        for(int j = 0; j < nums2.length; j++){
            if(map.containsKey(nums2[j])){
                if(map.get(nums2[j]) > 0){
                    list.add(nums2[j]);
                    map.put(nums2[j], map.get(nums2[j]) - 1);
                }
            }
        }
        int[] ret = new int[list.size()];
        for(int k = 0; k < list.size(); k++){
            ret[k] = list.get(k);
        }
        return ret;
    }

}
