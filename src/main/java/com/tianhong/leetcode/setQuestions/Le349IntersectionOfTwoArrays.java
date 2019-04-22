package com.tianhong.leetcode.setQuestions;

import java.util.*;

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
        Set<Integer> set = new HashSet<>();
        Set ret = new HashSet<>();
        for(int i : nums1){
            set.add(i);
        }
        for(int j = 0; j < nums2.length; j++){
            if(set.contains(nums2[j])){
                ret.add(nums2[j]);
            }
        }
        int k = 0;
        int[] arr = new int[ret.size()];
        for (Iterator it = ret.iterator(); it.hasNext(); ) {
            arr[k] = (int)it.next();
            k++;
        }
        return arr;
    }

    public static void main(String[] args) {
//        Integer[] numbers = {7, 7, 8, 9, 10, 8, 8, 9, 6, 5, 4};
//        // To convert an array into a Set first we convert it to a List. Next
//        // with the list we create a HashSet and pass the list as the constructor.
//        List list = Arrays.asList(numbers);
//        Set set = new HashSet(list);
        Set set = new HashSet();
        Object[] objectArray2 = set.toArray();
        Integer[] array2 = (Integer[]) set.toArray(new Integer[set.size()]);

    }


}
