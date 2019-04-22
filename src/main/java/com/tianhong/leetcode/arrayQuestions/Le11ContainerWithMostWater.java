package com.tianhong.leetcode.arrayQuestions;

// Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
// n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
// which together with x-axis forms a container, such that the container contains the most water.
//
// Note: You may not slant the container and n is at least 2.

// Input: [1,8,6,2,5,4,8,3,7]
// Output: 49
public class Le11ContainerWithMostWater {
//    public int maxArea(int[] height) {
//        int i = 0;
//        int j = height.length - 1;
//        int left = height[i];
//        int right = height[j];
//        int area = 0;
//        if(left >= right){
//            area = (j - i) * right;
//        } else {
//            area = (j - i) * left;
//        }
//        while(i < j){
//            area = getMax(height, i, j, area);
//            i++;
//        }
//        return area;
//    }
//
//    public int getMax(int[] height, int start, int end, int area){
//        int left = height[start];
//        int right = height[end];
//        int newArea;
//        if(left >= right){
//            newArea = (end - start) * right;
//        } else {
//            newArea = (end - start) * left;
//        }
//
//        if(start >= end){
//            return newArea > area ? newArea : area;
//        }
//
//        while(start < end){
//            if(height[end] <= right){
//                end--;
//            }
//        }
//
//        if(newArea > area){
//            return getMax(height, start, end, newArea);
//        } else {
//            return getMax(height, start, end, area);
//        }
//    }

    public int maxArea(int[] height) {
        int ret = 0, i = 0, j = height.length - 1;
        while(i < j){
            ret = Math.max(Math.min(height[i], height[j]) * (j - i), ret);
            if(height[i] < height[j]){
                i++;
            } else {
                j--;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 10, 8, 6, 3, 4};
        Le11ContainerWithMostWater test = new Le11ContainerWithMostWater();
        System.out.println("height: " + test.maxArea(array));
    }
}
