package com.tianhong.xiaoMA;

// 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
// {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
// 他们的最大值分别为{4,4,6,6,6,5}

import java.util.ArrayList;

public class MaxInWindow {
    public static ArrayList<Integer> maxInWindow(int[] nums, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if(size > nums.length || nums.length == 0) {
            return list;
        }
        for(int i = 0; i <= nums.length - size; i++) {
            int temp = nums[i];
            for(int j = i; j < i + size; j++) {
                if(nums[j] > temp) {
                    temp = nums[j];
                }
            }
            list.add(temp);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] test = {2,3,4,2,6,2,5,1};
        ArrayList<Integer> list = maxInWindow(test, 3);
        for(Integer i : list) {
            System.out.println(i);
        }
    }

}
