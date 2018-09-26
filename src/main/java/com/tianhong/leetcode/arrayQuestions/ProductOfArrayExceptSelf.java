package com.tianhong.leetcode.arrayQuestions;

// Input:  [1,2,3,4]
// Output: [24,12,8,6]   24 = 2*3*4
// Please solve it without division and in O(n).
public class ProductOfArrayExceptSelf {
    //维护两个数组， fwd[]和bwd[], 分别为当前元素之前所有元素乘积和之后所有元素乘积
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] fwd = new int[n];
        int[] bwd = new int[n];
        int[] ret = new int[n];
        fwd[0] = 1;
        for(int i = 1; i < n; i++){
            fwd[i] = fwd[i-1]*nums[i-1];
        }
        bwd[n-1] = 1;
        for(int j = n -2; j >= 0; j--){
            bwd[j] = bwd[j+1]*nums[j+1];
        }

        for(int k = 0; k < n; k++){
            ret[k] = fwd[k] * bwd[k];
        }
        return ret;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf test = new ProductOfArrayExceptSelf();
        int[] input = new int[]{1, 2, 3, 4};
        int[] ret = test.productExceptSelf(input);
    }
}
