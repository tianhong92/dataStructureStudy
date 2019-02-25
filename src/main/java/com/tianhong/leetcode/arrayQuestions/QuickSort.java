package com.tianhong.leetcode.arrayQuestions;


// 算法思想：基于分治的思想，是冒泡排序的改进型。
// 首先在数组中选择一个基准点（该基准点的选取可能影响快速排序的效率，后面讲解选取的方法），
// 然后分别从数组的两端扫描数组，设两个指示标志（lo指向起始位置，hi指向末尾)，首先从后半部分开始，
// 如果发现有元素比该基准点的值小，就交换lo和hi位置的值，然后从前半部分开始扫秒，发现有元素大于基准点的值，就交换lo和hi位置的值，
// 如此往复循环，直到lo>=hi,然后把基准点的值放到hi这个位置。一次排序就完成了。以后采用递归的方式分别对前半部分和后半部分排序，
// 当前半部分和后半部分均有序时该数组就自然有序了。

// 基准点选择会影响效率
public class QuickSort {

    // O(n)
    public static int partition(int[] nums, int start, int end){
        if(start >= end){
            return start;
        }
        int key = nums[start];
        while(start < end){
            if(end > start && nums[end] >= key){
                end--;
            }
            nums[start] = nums[end];
            while(end > start && nums[start] <= key){
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = key;
        return start;
    }


    // O(logn)
    public static int[] sort(int[] nums, int start, int end){
        if(start >= end){
            return nums;
        }
        int key = partition(nums, start, end);
        sort(nums, 0, key - 1);
        sort(nums, key + 1, end);
        return nums;
    }

    public static void main(String[] args) {
        int[] test = new int[] {5, 3, 7, 8, 10, 2, 1};
        int[] result = sort(test, 0, test.length - 1);
        for(int i : result){
            System.out.print(i+" ");
        }
    }
}
