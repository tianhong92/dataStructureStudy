package com.tianhong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {

    public static void quickSort(List<Integer> list) {
        int length = list.size();
        if(length == 0) {
            return;
        }
        if(length == 1) {
            System.out.println(list.get(0));
            return;
        }
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();
        int pivot = list.get(0);
        for(int i = 1; i < length; i++) {
            if(list.get(i) >=  list.get(0)) {
                right.add(list.get(i));
            } else {
                left.add(list.get(i));
            }
        }

        if(left.size() != 0) {
            quickSort(left);
        }
        System.out.println(pivot);
        if(right.size() != 0) {
            quickSort(right);
        }
    }

    public static void main(String[] args) {
        List<Integer> test = Arrays.asList(2, 6, 4, 8, 1);
        quickSort(test);
    }
}
