package com.tianhong.leetcode.arrayQuestions;
// write a function to move all 0's to the end of it while maintaining the
// relative order of the non-zero elements.
// Input: [0,1,0,3,12]
// Output: [1,3,12,0,0]
public class Le283MoveZeroes {
    public void moveZeroes(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if(nums[j] != 0){
                        swap(nums, i, j);
                        break;
                    }
                }
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 不需要交换， 运用两个下标
    public void solution2(int[] nums){
        int k = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[k++] = nums[i];
            }
        }
        for(int j = k; j < nums.length; j++){
            nums[j] = 0;
        }
    }

    public static void main(String[] args) {
        Le283MoveZeroes test = new Le283MoveZeroes();
        int[] array = new int[]{0, 1, 0, 3, 12};
        test.solution2(array);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]+" ");
        }
    }
}
