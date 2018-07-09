package com.tianhong;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    public static int[] quickSort(int[] arr, int startIndex, int endIndex) {
        if(startIndex >= endIndex) {
            return new int[]{};
        }
        int pivot = arr[startIndex];
        List<Integer> list = new ArrayList<Integer>();
        list.add(pivot);
        int count = 0;
        for(int i = startIndex; i < endIndex; i++) {
            if(arr[i + 1] < pivot) {
                 list.add(0, arr[i+1]); 
                 count++;
            } else {
                list.add(arr[i+1]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(454545);
    }
}
