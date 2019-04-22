package com.tianhong.leetcode.arrayQuestions;

// Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
// The number of elements initialized in nums1 and nums2 are m and n respectively.
// You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
public class Le88MergeSortedArray {

    // 冒泡排序
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 1; i <= n; i++){
            nums1[m-1+i] = nums2[i-1];
        }
        for(int j = 0; j < m + n - 1; j++){
            for(int k = 0; k < m + n - 1 - j; k++){
                if(nums1[k] > nums1[k+1]) {
                    int temp = nums1[k];
                    nums1[k] = nums1[k + 1];
                    nums1[k + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{2, 5, 3, 0, 0, 0};
        int[] a2 = new int[]{1, 7, 4};
        Le88MergeSortedArray test = new Le88MergeSortedArray();
        test.merge1(a1, 3, a2, 3);
        for(int i : a1){
            System.out.print(i+" ");
        }
    }
}
