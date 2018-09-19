package com.tianhong.leetcode.arrayQuestions;

// switching the row and column indices of the matrix.
// Input: [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[1,4,7],[2,5,8],[3,6,9]]
public class TransposeMatrix {
    // Solution one: copy directly from A[R][C] to B[C][R]
    public int[][] transpose(int[][] A) {
        int rows = A.length;
        int columns = A[0].length;
        int[][] B = new int[columns][rows];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                B[j][i] = A[i][j];
            }
        }
        return B;
    }
}
