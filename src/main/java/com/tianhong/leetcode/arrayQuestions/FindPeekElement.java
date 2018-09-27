package com.tianhong.leetcode.arrayQuestions;
// return the index of peek element
// Input: nums = [1,2,3,1]
// Output: 2
// Input: nums = [1,2,1,3,5,6,4]
// Output: 1 or 5
public class FindPeekElement {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        for(int i = 1; i < nums.length - 1; i++){
            int pre = nums[i -1];
            int cur = nums[i];
            int next = nums[i+1];
            if(cur > pre && cur > next){
                return i;
            }
        }
        return -1;
    }
}
