package com.tianhong.leetcode.arrayQuestions;

// Find the kth largest element in an unsorted array.
// Note that it is the kth largest element in the sorted order, not the kth distinct element.
// Input: [3,2,1,5,6,4] and k = 2
// Output: 5
public class Le215KthLargestElement {
    // use quick sort partition to return key index
    public int findKthLargest(int[] nums, int k) {
        //You may assume k is always valid, 1 ≤ k ≤ array's length.
        int exp = nums.length - k;
        int ret = sort(nums, 0, nums.length - 1, exp);
        System.out.println("ret = "+ ret);
        return nums[ret];
    }

    public static int sort(int[] nums, int start, int end, int k){
        if(start >= end){
            return end;
        }
        int ret = partition(nums, start, end);
        if(ret == k){
            return ret;
        } else if(ret > k){
            return sort(nums, start, ret - 1, k);
        } else {
            return sort(nums, ret + 1, end, k);
        }
    }

    public static int partition(int[] nums, int start, int end){
        if(start >= end){
            return start;
        }
        int key = nums[start];
        while(start < end){
            while(start < end && nums[end] >= key){
                end--;
            }
            nums[start] = nums[end];
            while(start < end && nums[start] <= key){
                start++;
            }
            nums[end] = nums[start];
        }
        nums[end] = key;
        return end;
    }

    public static void main(String[] args) {
        Le215KthLargestElement test = new Le215KthLargestElement();
        int[] array = new int[]{-1, 2, 0};
        int ret = test.findKthLargest(array, 2);
        System.out.println("val: "+ret);
    }
}
