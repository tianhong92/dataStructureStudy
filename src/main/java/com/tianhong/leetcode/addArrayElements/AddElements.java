package com.tianhong.leetcode.addArrayElements;

public class AddElements {
    public static void main(String[] args) {
       int[] array = {1, 3, 5, 7, 9};
       AddElements addElements = new AddElements();
       System.out.println("Sum = " + addElements.sum2(array,  3));
    }

    // return array[l, n)
    private int sum(int[] array, int l) {
        if(l > array.length)
            return -1;
        if(l == array.length)
            return 0;
        return sum(array, l+1) + array[l];
    }


    // return array[0, l]
    private int sum2(int[] array, int l) {
        if(l == 0) {
            return array[0];
        }

        return sum2(array, l -1) + array[l];
    }
}
