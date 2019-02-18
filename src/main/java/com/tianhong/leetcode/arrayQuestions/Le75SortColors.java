package com.tianhong.leetcode.arrayQuestions;

// 三路快排
// 给定一个n个元素数组， 数组中元素只有0，1，2三种可能， 给这个数组排序；
public class Le75SortColors {
    //计数排序。 统计每种元素出现的次数
    public int[] solution1(int[] nums){
        int[] count = new int[3];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                count[0]++;
            } else if (nums[i] == 1){
                count[1]++;
            } else {
                count[2]++;
            }

        }

        for(int j = 0; j < nums.length; j++){
            if(j <= count[0] - 1){
                nums[j] = 0;
            } else if (j > (count[0] - 1) && j <= count[0] + count[1] - 1){
                nums[j] = 1;
            } else {
                nums[j] = 2;
            }
        }
        return nums;
    }

    // Quick sort 3 ways
    public int[] solution2(int[] nums){
        if(nums.length <= 1){
            return nums;
        }
        int lt = -1;
        int gt = nums.length;

        for(int i = 0; i < gt;){
            if(nums[i] == 1){
                i++;
            } else if (nums[i] == 2){
                swap2(nums, i, gt - 1);
                gt--;
            } else {
                swap2(nums, i, lt + 1);
                lt++;
                i++;
            }
        }
        return nums;
    }

    private void swap2(int[] nums, int a, int b){
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }

    public static void main(String[] args) {
        int[] test = new int[] {2, 2};
        Le75SortColors le = new Le75SortColors();
        le.solution2(test);
        for(int i =0; i < test.length; i++){
            System.out.print(test[i]+" ");
        }
    }
}
