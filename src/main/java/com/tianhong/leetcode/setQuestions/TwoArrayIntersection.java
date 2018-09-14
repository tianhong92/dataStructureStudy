package com.tianhong.leetcode.setQuestions;
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]
// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
public class TwoArrayIntersection {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set set = new HashSet();
        ArrayList<Integer> list = new ArrayList();
        for(int num : nums1){
            set.add(num);
        }
        for(int num2 : nums2){
            if(set.contains(num2)){
                list.add(num2);
                set.remove(num2);
            }
        }
        int[] ret = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ret[i] = list.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 2, 4, 1, 5, 2};
        int[] nums2 = {8, 3, 11, 2, 4, 1, 0, 7};
        int[] res = intersection(nums1, nums2);
        for(int i = 0; i < res.length; i++){
            if(res.length -i == 1){
                System.out.print(res[i]);
            } else {
                System.out.print(res[i] + ", ");
            }
        }
    }
}
