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
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int rows = nums.length;
        int columns = nums[0].length;
        if(r == 0 || c == 0 || r*c < rows*columns){
            return nums;
        } else {
            List<Integer> list = new LinkedList<>();
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < columns; j++){
                    list.add(nums[i][j]);
                }
            }
            int[][] res = new int[r][c];
            for(int k = 0; k < r; k++){
                for(int h = 0; h < c; h++){
                    res[k][h] = list.get(0);
                    list.remove(0);
                }
            }
            return res;
        }
    }
}
