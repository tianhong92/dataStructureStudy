package com.tianhong.leetcode.arrayQuestions;

import java.util.Arrays;

// Given an array A of non-negative integers,
// return an array consisting of all the even elements of A,
// followed by all the odd elements of A
// Input: [3,1,2,4]
// Output: [2,4,3,1]
public class SortArrayByParty {

    // Solution one, Use a custom comparator when sorting, to sort by parity.
    // O(NlogN)
    public static int[] sort1(int[] array){
        Integer[] B = new Integer[array.length];
        for(int i = 0; i < array.length; i++)
            B[i] = array[i];
        Arrays.sort(B, (a, b) -> Integer.compare(a%2, b%2));
        for(int i = 0; i < array.length; i++)
            array[i] = B[i];
        return array;
    }

    // Solution two, Two Pass, Write all the even elements first, then write all the odd elements.
    // O(2N)
    public static int[] sort2(int[] array){
        int[] ret = new int[array.length];
        for(int i = 0; i < array.length; i++){
            if(array[i]%2 == 0)
                ret[i++] = array[i];
        }
        for(int i = 0; i < array.length; i++){
            if(array[i]%2 == 1)
                ret[i++] = array[i];
        }
        return ret;
    }

    // Solution 3, in-place
    // quicksort
    // array[i]%2 == 0 && array[j]%2 == 0  i++
    // array[i]%2 == 0 && array[j]%2 == 1  i++ j++
    // array[i]%2 == 1 && array[j]%2 == 0  swap i++ j++
    // array[i]%2 == 1 && array[j]%2 == 1  j--
    // O(n)
    public static int[] sort3(int[] array){
        int i = 0;
        int j = array.length - 1;
        while(i < j){
            if(array[i]%2 > array[j]%2){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            if(array[i]%2 == 0)
                i++;
            if(array[j]%2 == 1)
                j--;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 0, 4, 3, 8, 2, 3};
        int[] ret = sort1(arr1);
        for(int i :ret)
            System.out.print(i+" ");

    }
}
