package com.tianhong.leetcode;

public class DaxiInterview {
    public static void sort(int[] arr, int start, int end) {
        if(start == end) {
            System.out.println("Max integer:" + arr[start]);
        }
        int midIndex = (int) Math.floor((start + end)/2);
        if(arr[midIndex] > arr[arr.length -1]) {
            sort(arr, start, midIndex);
        }
        if(arr[midIndex] <= arr[arr.length -1]) {
            sort(arr, midIndex, end);
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{7, 8, 9, 10, 1, 2, 3, 5, 6};
        sort(arr, 0, arr.length -1);
    }
}
