package com.tianhong.leetcode.arrayQuestions;
import java.util.HashSet;
import java.util.Set;

// Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist.
// Assume that there is only one duplicate number, find the duplicate one.
// Input: [1,3,4,2,2]
//  Output: 2
public class FindDuplicateNumber287 {
    // Time complexity: O(n)
    // Space complexity: O(n)
    public int findDuplicate(int[] nums) {
        Set<Integer> list = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(list.contains(nums[i]))
                return nums[i];
            else
                list.add(nums[i]);
        }
        return -1;
    }

    // Solution 2: Tortoise and Hare
    public int findDuplicate2(int[] nums){
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }

}
