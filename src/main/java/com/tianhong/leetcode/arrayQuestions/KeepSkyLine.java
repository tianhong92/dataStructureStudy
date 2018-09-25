package com.tianhong.leetcode.arrayQuestions;

//Max Increase to Keep City Skyline

public class KeepSkyLine {
    public static int[] x;
    public static int[] y;
    public static void main(String[] args) {
        int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        x = new int[4];
        y = new int[4];

        maxHeight(grid);
        maxIncrease(grid);
    }

    public static void maxHeight(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] > x[i]) {
                    x[i] = grid[i][j];
                }
                if(grid[i][j] > y[j]) {
                    y[j] = grid[i][j];
                }
            }
        }
    }

    public static int maxIncrease(int[][] grid) {
        int increase = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] < x[i] && grid[i][j] < y[j]) {
                    int diff = x[i] < y[j] ? x[i] - grid[i][j] : y[j] - grid[i][j];
                    increase += diff;
                }
            }
        }
        return increase;
    }
}
