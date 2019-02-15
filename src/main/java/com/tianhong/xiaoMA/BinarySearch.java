package com.tianhong.xiaoMA;

/**
 * @author TianhongWang
 * @since 2019/2/15
 */

// [ 1， 2， 3， 4， 5， 6， 7, 8， 9， 10] 中找3的下标
public class BinarySearch {
    public int binarySearch(int[] array, int target){
        return search(array, target, 0, array.length - 1);
    }

    private int search(int[] array, int target, int start, int end){
        if((Math.abs(start-end) == 1 && target > array[end]) || (Math.abs(start-end) == 1 && target < array[start])){
            return -1;
        }
        if(array[(start + end)/2] == target){
            return (start + end)/2;
        } else {
            if(array[(start + end)/2] < target) {
                return search(array, target, (start + end) / 2, end);
            } else {
                return search(array, target, start, (start+end)/2);
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        BinarySearch search = new BinarySearch();
        int ret = search.binarySearch(test, -2);
        System.out.println(ret);
    }
}
