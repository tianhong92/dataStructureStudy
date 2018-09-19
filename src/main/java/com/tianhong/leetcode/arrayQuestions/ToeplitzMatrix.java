package com.tianhong.leetcode.arrayQuestions;

import java.util.HashMap;
import java.util.Map;

//Input: matrix = [
//  [1,2,3,4],
//  [5,1,2,3],
//  [9,5,1,2]
//]
//Output: True
public class ToeplitzMatrix {
    // Belong to the same diagonal, for A[i][j] i - j must equal to certain value
    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        Map<Integer, Integer> hash = new HashMap<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(!hash.containsKey(i-j))
                    hash.put(i-j, matrix[i][j]);
                else if (hash.get(i-j) != matrix[i][j])
                        return false;
            }
        }
        return true;
    }

    // compare to the top left neighbor
    public boolean isToeplitzMatrix2(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(i > 0 && j > 0 && matrix[i][j] != matrix[i-1][j-1])
                    return false;
            }
        }
        return true;
    }
}
