package com.tianhong.leetcode.arrayQuestions;

/**
 * @author TianhongWang
 * @since 2019/1/22
 */
// Given an array A of non-negative integers, half of the integers in A are odd,
// and half of the integers are even.
//Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.

//Example 1:
//
//Input: [4,2,5,7]
//Output: [4,5,2,7]
//Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
public class Le922SortArrayByParty {
    public static int[] sortArrayByParityII(int[] A) {
        int[] ret = new int[A.length];
        int even = 0;
        for(int i = 0; i < A.length; i++){
            if (A[i] % 2 == 0) {
                ret[even] = i;
                even += 2;
            }
        }
        int odd = 1;
        for(int j = 0; j < A.length; j++) {
            if(A[j] % 2 == 1) {
                ret[odd] = j;
                odd += 2;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] ret = sortArrayByParityII(new int[] {7, 3, 2, 4});
        for(int i : ret){
            System.out.println(i+" ");
        }
    }
}
