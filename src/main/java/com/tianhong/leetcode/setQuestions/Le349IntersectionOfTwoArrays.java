package com.tianhong.leetcode.setQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Given two arrays, write a function to compute their intersection.
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]
// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]
// Note:
// Each element in the result must be unique.
// The result can be in any order.
public class Le349IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        int length = nums1.length > nums2.length ? nums1.length : nums2.length;
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i : nums1){
            set.add(i);
        }
        for(int j = 0; j < nums2.length; j++){
            if(set.contains(nums2[j])){
                list.add(nums2[j]);
                set.remove(nums2[j]);
            }
        }

        int[] ret = new int[list.size()];
        for(int k = 0; k < list.size(); k++){
            ret[k] = list.get(k);
        }
        return ret;
    }


}
