package com.tianhong.leetcode.arrayQuestions;

public class Le169MajorityElement {
    // moore voting algorithm
    // http://www.cs.utexas.edu/~moore/best-ideas/mjrty/example.html
    public int majorityElement(int[] nums) {
        int ele = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(count == 0) {
                ele = nums[i];
                count++;
            } else {
                if(ele == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return ele;
    }
}
