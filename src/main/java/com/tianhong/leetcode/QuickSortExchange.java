package com.tianhong.leetcode;

public class QuickSortExchange {

    public static int divide(int[] arr, int start, int end) {
        while(start < end) {
            while(start < end && arr[start] <= arr[end]) {
                start++;
            }
            if(arr[start] > arr[end]) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                end--;
            }

            while(start < end && arr[start] < arr[end]) {
                end--;
            }
            if(arr[end] < arr[start]) {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
        }
        return start;
    }

    public static void sort(int[] a, int start, int end) {
        if(start > end) {
            return;
        }
        int partition = divide(a, start, end);
        sort(a, start, partition - 1);
        sort(a, partition + 1, end);
    }


    public static void main(String[] args) {

        int[] a = new int[]{2,7,4,5,10,1,9,3,8,6};
        int[] b = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] c = new int[]{10,9,8,7,6,5,4,3,2,1};
        int[] d = new int[]{1,10,2,9,3,2,4,7,5,6};

        sort(c, 0, a.length-1);

        System.out.println("排序后的结果：");
        for(int x : c){
            System.out.print(x+" ");
        }
    }

}