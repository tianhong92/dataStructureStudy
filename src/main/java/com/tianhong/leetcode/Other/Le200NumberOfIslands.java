package com.tianhong.leetcode.Other;

// Flood fill algorithm

public class Le200NumberOfIslands {
    private boolean[][] taken;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int x = grid.length;
        int y = grid[0].length;
        taken = new boolean[x][y];
        int islandCount = 0;
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                if(grid[i][j] == '1' && !taken[i][j]) {
                    floodFill(grid, i, j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    public void floodFill(char[][] grid, int x, int y) {
        if(!inArea(grid, x, y) || taken[x][y] || grid[x][y] == '0')
            return;
        if(grid[x][y] == '1' && !taken[x][y]) {
            taken[x][y] = true;
            floodFill(grid, x - 1, y);
            floodFill(grid, x + 1, y);
            floodFill(grid, x, y - 1);
            floodFill(grid, x, y + 1);
        }
    }

    public boolean inArea(char[][] grid, int x, int y) {
        if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length)
            return true;
        else
            return false;
    }
}
