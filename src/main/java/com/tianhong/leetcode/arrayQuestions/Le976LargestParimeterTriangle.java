package com.tianhong.leetcode.arrayQuestions;

import java.util.Arrays;

/**
 * @author TianhongWang
 * @since 2019/1/30
 */
// Given an array A of positive lengths, return the largest perimeter of a triangle with non-zero area,
// formed from 3 of these lengths.

// Note；
// 3 <= A.length <= 10000
// 1 <= A[i] <= 10^6

// Input: [2,1,2]
// Output: 5

// Input: [3,2,3,4]
// Output: 10
public class Le976LargestParimeterTriangle {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for(int i = A.length - 1; i >= 2; i--){
            if((A[i-1] + A[i-2]) > A[i]){
                return A[i-1] + A[i-2] + A[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] test = new int[] { 3, 2, 3, 4 };
        int ret = new Le976LargestParimeterTriangle().largestPerimeter(test);
        System.out.println("rest is: " + ret);
    }
}
