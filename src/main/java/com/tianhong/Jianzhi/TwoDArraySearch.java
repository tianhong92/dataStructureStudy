package com.tianhong.Jianzhi;

/**
 * @Author: TianhongWang
 * @Date: 2018/11/28
 * @Description
 */

// 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
// 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
// Consider the following matrix:
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
//
//  Given target = 5, return true.
//  Given target = 20, return false.

public class TwoDArraySearch {
    public static boolean Find(int target, int[][] matrix) {
        return IncludeTarget(matrix, matrix.length - 1, 0, target);
    }

    public static boolean IncludeTarget(int[][] matrix, int i, int j, int target){
        if(i < 0 || j >= matrix[0].length){
            return false;
        }
        if(matrix[i][j] == target){
            return true;
        }
        if(matrix[i][j] > target){
            i = i-1;
            return IncludeTarget(matrix, i, j, target);
        } else {
            j = j+1;
            return IncludeTarget(matrix, i, j, target);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(Find(100, matrix));
    }
}
