package com.tianhong.leetcode.addArrayElements;

public class AddElements {
    public static void main(String[] args) {
       int[] array = {1, 3, 5, 7, 9};
       AddElements addElements = new AddElements();
       int ret = addElements.getSum2(array, 0);
        System.out.println(ret);
    }

    // return array[0, l)
    public static int getSum(int[] array, int l){
        if(l == 1){
            return array[0];
        }
        return getSum(array, l-1) + array[l-1];
    }

    // return array(l， l]
    public static int getSum2(int[] array, int l) {
        if(l == array.length - 1){
            return array[l];
        }
        return getSum2(array, l+1) + array[l];
    }

}
