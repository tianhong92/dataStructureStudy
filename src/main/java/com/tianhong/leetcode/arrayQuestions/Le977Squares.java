package com.tianhong.leetcode.arrayQuestions;

import java.util.Arrays;

/**
 * @author TianhongWang
 * @since 2019/1/22
 */

// Given an array of integers A sorted in non-decreasing order, return an array
// of the squares of each number, also in sorted non-decreasing order.
//
//Input: [-4,-1,0,3,10]
//Output: [0,1,9,16,100]

public class Le977Squares {

    public static int[] sortedSquares2(int[] A) {
        int[] ret = new int[A.length];
        for(int i = 0; i < A.length; i++){
            ret[i] = A[i] * A[i];
        }
        Arrays.sort(ret);
        return ret;
    }
    public static int[] sortedSquares(int[] A) {
        int[] ret = new int[A.length];
        for(int i = 0; i < A.length; i++){
            ret = insert(ret, A[i] * A[i], i, i);
        }
        return ret;
    }

    public static int[] insert(int[] array, int target, int pos, int taken){
        if(pos == 0){
            if(taken == 0) {
                array[pos] = target;
            } else {
                for(int j = taken; j > 0; j--){
                    array[j] = array[j-1];
                }
                array[0] = target;
            }
            return array;
        }
        if(array[pos-1] <= target){
            for(int g = taken; g > pos; g--){
                array[g] = array[g-1];
            }
            array[pos] = target;
        } else {
            insert(array, target, pos - 1, taken);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] test = new int[]{3, -1, 0, 5, 7, 6};
        int[] rst = sortedSquares(test);
        for(int i = 0; i < rst.length; i++){
            if(i == rst.length - 1){
                System.out.println(rst[i]);
            } else {
                System.out.print(rst[i] + ", ");
            }
        }
    }
}
