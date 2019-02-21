package com.tianhong.leetcode.arrayQuestions;

// Given an array of n positive integers and a positive integer s,
// find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
// Input: s = 7, nums = [2,3,1,2,4,3]
// Output: 2  -----> [4, 3]

// Follow up:
// If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
public class Le209MinimumSizeSubarraySum {
    // 移动窗口
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int length = 0;
        //改变窗口的大小, 窗口为[i， j]
        outter:for(int wSize = 1; wSize <= nums.length; wSize++){
            int left = 0;
            int right = wSize - 1;
            while(right < nums.length) {
                int temp = 0;
                for (int k = left; k <= right; k++) {
                    temp += nums[k];
                }
                if (temp >= s) {
                    length = wSize;
                    break outter;
                }
                left++;
                right++;
            }
        }
        return length;
    }

    //real滑动窗口
    public int minSubArrayLen2(int s, int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int l = 0, r = -1; // 滑动窗口[l, r]
        int sum = 0;
        int length = nums.length + 1;
        while(l < nums.length && r < nums.length){
            if(r+1 < nums.length && sum < s){
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }

            if(sum >= s && (r - l + 1) < length){
                length = (r - l + 1);
            }
        }
        if(length == nums.length + 1)
            return 0;
        else
            return length;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 4, 5, 8, 7};
        Le209MinimumSizeSubarraySum test = new Le209MinimumSizeSubarraySum();
        int ret = test.minSubArrayLen2(16, array);
        System.out.println(ret);
    }
}
