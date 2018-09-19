package com.tianhong.leetcode.arrayQuestions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

// Input: nums = [[1,2], [3,4]]
// r = 1, c = 4
// Output:
// [[1,2,3,4]]
public class ReshapeMatrix {
    // 1. using queue
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int rows = nums.length;
        int columns = nums[0].length;
        if(r == 0 || c == 0 || r*c != rows*columns){
            return nums;
        } else {
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < columns; j++){
                    queue.add(nums[i][j]);
                }
            }
            int[][] res = new int[r][c];
            for(int k = 0; k < r; k++){
                for(int h = 0; h < c; h++){
                    res[k][h] = queue.remove();
                }
            }
            return res;
        }
    }

    // 2. without using extra space
    public int[][] matrixReshape2(int[][] nums, int r, int c) {
        int rows = nums.length;
        int columns = nums[0].length;
        if(r == 0 || c == 0 || r*c != rows*columns){
            return nums;
        } else {
            int rowIndex = 0;
            int colIndex = 0;
            int[][] ret = new int[r][c];
            for(int i = 0; i < nums.length; i++){
                for(int j = 0; j < nums[0].length; j++){
                    ret[rowIndex][colIndex] = nums[i][j];
                    colIndex++;
                    if(colIndex == c) {
                        rowIndex++;
                        colIndex = 0;
                    }
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        int[][] test = new int[][] {{1,2}, {3,4}};
        ReshapeMatrix rm = new ReshapeMatrix();
        int[][] ret = rm.matrixReshape(test, 1, 4);
        System.out.println(ret.length);
        System.out.println(ret[0].length);
        for(int i = 0; i < ret.length; i++){
            for(int j = 0; j < ret[0].length; j++){
                System.out.print(ret[i][j]);
            }
        }
    }
}
