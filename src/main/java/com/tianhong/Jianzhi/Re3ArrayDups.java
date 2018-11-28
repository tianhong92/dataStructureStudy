package com.tianhong.Jianzhi;

/**
 * @Author: TianhongWang
 * @Date: 2018/11/28
 * @Description
 */

// 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，
// 但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
// 用到交换元素位置的思想， 值为i的元素交换i位置元素
// Parameters:
//    numbers:     an array of integers
//    length:      the length of array numbers
//    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
//                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
//    这里要特别注意~返回任意重复的一个，赋值duplication[0]
// Return value:       true if the input is valid, and there are some duplications in the array number
//                     otherwise false
public class Re3ArrayDups {
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        int i = 0;
        while(i < length ){
            if(numbers[i] == i){
                i++;
            } else if (numbers[i] == numbers[numbers[i]]){
                duplication[0] = numbers[i];
                return true;
            } else {
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }
    public static void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3, 0, 4};
        int[] dups = new int[1];
        System.out.println(duplicate(test, 5, dups));
        System.out.println(dups[0]);
    }
}
