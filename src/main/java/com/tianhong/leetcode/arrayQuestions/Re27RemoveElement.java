package com.tianhong.leetcode.arrayQuestions;

/**
 * @author TianhongWang
 * @since 2019/1/29
 */
// Given an array nums and a value val,
// remove all instances of that value in-place and return the new length.
// Given nums = [3,2,2,3], val = 3, return 2;
// Given nums = [0,1,2,2,3,0,4,2], val = 2, return 5;
public class Re27RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
