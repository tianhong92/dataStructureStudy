package com.tianhong.leetcode.addArrayElements;

public class AddElements {
    public static void main(String[] args) {
       int[] array = {1, 3, 5, 7, 9};
       AddElements addElements = new AddElements();
       int ret = addElements.getSum(array, array.length);
        System.out.println(ret);
    }

    public static int getSum(int[] array, int l){
        if(l == 1){
            return array[0];
        }
        return getSum(array, l-1) + array[l-1];
    }

}
