package com.tianhong.leetcode.arrayQuestions;
// Given an array of integers that is already sorted in ascending order,
// find two numbers such that they add up to a specific target number.
//
// The function twoSum should return indices of the two numbers such that
// they add up to the target, where index1 must be less than index2.
//
// Note: Your returned answers (both index1 and index2) are not zero-based.
// You may assume that each input would have exactly one solution and you may not use the same element twice.

import java.util.ArrayList;
import java.util.List;

// Input: numbers = [2,7,11,15], target = 9
// Output: [1,2]
public class Le167TwoSum2 {
    public int[] twoSum1(int[] numbers, int target) {
        int[] index = new int[2];
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < numbers.length; i++){
            if(list.contains(numbers[i])){
                index[0] = list.indexOf(numbers[i])+1;
                index[1] = i+1;
                return index;
            } else {
                list.add(target - numbers[i]);
            }
        }
        return index;
    }

    // binary search
    public int[] twoSum2(int[] numbers, int target){
        int[] index = new int[2];
        for(int i = 0; i < numbers.length; i++){
            int search = target - numbers[i];
            int ret = binarySearch(numbers, i+1, numbers.length-1, search);
            if(ret != -1){
                index[0] = i+1;
                index[1] = ret+1;
                break;
            }
        }
        return index;
    }

    public int binarySearch(int[] nums, int start, int end, int target){
        if(start > end){
            return -1;
        }
        if(start == end && nums[start] == target){
            return start;
        }
        int mid = (start + end)/2;

        if(nums[mid] == target){
            return mid;
        } else if (nums[mid] < target){
            return binarySearch(nums, mid + 1, end, target);
        } else {
            return binarySearch(nums, start, mid - 1, target);
        }
    }

    // Solution 3: 对撞指针
    public int[] twoSum3(int[] numbers, int target){
        if(numbers.length < 2){
            throw new IllegalArgumentException("Array is too short!");
        }
        int i = 0;
        int j = numbers.length - 1;
        while(i < j){
            int sum = numbers[i] + numbers[j];
            if(sum == target){
                return new int[]{i+1, j+1};
            } else if (sum < target){
                i++;
            } else {
                j--;
            }
        }
        throw new IllegalArgumentException("Not valid parameter!");
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 25, 75};
        Le167TwoSum2 test = new Le167TwoSum2();
        int[] ret = test.twoSum2(arr, 100);
        System.out.println("first: "+ret[0]+" second: "+ret[1]);
    }
}
