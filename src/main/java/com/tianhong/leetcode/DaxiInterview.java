package com.tianhong.leetcode;

public class DaxiInterview {
    public static void sort(int[] arr, int start, int end) {
        if(end - start == 1) {
            System.out.println(arr[start] > arr[end] ? arr[start] : arr[end]);
            return;
        }
        int midIndex = (end + start)/2;
        if(arr[midIndex] > arr[arr.length - 1]) {
            sort(arr, midIndex, end);
        }
        if(arr[midIndex] <= arr[arr.length - 1]) {
            sort(arr, start, midIndex);
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{7, 8, 9, 10, 45, 78, 1, 2, 3, 5, 6};
        sort(arr, 0, arr.length -1);
    }
}
