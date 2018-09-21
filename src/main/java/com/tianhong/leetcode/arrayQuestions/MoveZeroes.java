package com.tianhong.leetcode.arrayQuestions;
// write a function to move all 0's to the end of it while maintaining the
// relative order of the non-zero elements.
// Input: [0,1,0,3,12]
// Output: [1,3,12,0,0]
public class MoveZeroes {
    // move 0 to the end of the array, and move forward the elements after the 0
    public static void moveZeroes(int[] nums) {
        int i = 0;
        int k = 0;
        int n = 0;
        while(i < nums.length){
            if(nums[k] == 0){
                for(int j = k; j < nums.length - n - 1; j++){
                    nums[j] = nums[j+1];
                }
                nums[nums.length - n - 1] = 0;
                i++;
                n++;

            } else {
                i++;
                k++;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{ 0, 0, 1, 2, 0, 5};
        moveZeroes(test);
        System.out.println("end");
    }
}
