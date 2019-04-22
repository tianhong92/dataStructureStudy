package com.tianhong.leetcode.Other;

import java.util.ArrayList;
import java.util.List;

public class Le417PacificAtlanticWaterFlow {
    private List<int[]> list;
    private boolean[][] passable;
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if(matrix == null || matrix.length < 1)
            return new ArrayList<>();
        list = new ArrayList<>();
        int x = matrix.length;
        int y = matrix[0].length;
        passable = new boolean[x][y];
        for(int i = 0 ; i < x; i++){
            for(int j = 0; j < y; j++) {
                if(passable[i][j] || canPass(matrix, i, j, matrix[i][j], new boolean[x][y]) == 3) {
                    list.add(new int[]{i, j});
                }
            }
        }
        return list;
    }

    // to pacific return 1; to atlantic return 2;
    public int canPass(int[][] matrix, int x, int y, int height, boolean[][] visited) {
        if(inConti(matrix, x, y)){
            if(visited[x][y] || matrix[x][y] > height)
                return 0;
            if(passable[x][y])
                return 3;
        } else {
            if (inAtlantic(matrix, x, y))
                return 1;
            if (inPacific(matrix, x, y))
                return 2;
        }

        // left, up, right, down
        int left = 0, up = 0, right = 0, down = 0;
        visited[x][y] = true;
        left = canPass(matrix, x, y - 1, matrix[x][y], visited);
        up = canPass(matrix, x - 1, y, matrix[x][y], visited);
        right = canPass(matrix, x, y + 1, matrix[x][y], visited);
        down = canPass(matrix, x + 1, y, matrix[x][y], visited);

        if(resultAna(left, up, right, down) == 3)
            passable[x][y] = true;
        return resultAna(left, up, right, down);
    }

    public boolean inPacific(int[][] matrix, int x, int y) {
        return x < 0 || y < 0 ? true : false;
    }

    public boolean inAtlantic(int[][] matrix, int x, int y) {
        return x >= matrix.length || y >= matrix[0].length ? true : false;
    }

    public boolean inConti(int[][] matrix, int x, int y) {
        return x >=0 && y >=0 && x < matrix.length && y < matrix[0].length ? true : false;
    }

    public int resultAna(int left, int up, int right, int down){
        int toPacifit = 0;
        int toAtlantic = 0;
        if(left == 3 || up == 3 || right == 3 || down == 3){
            return 3;
        } else {
            if(left == 1 || up == 1 || right == 1 || down == 1)
                toPacifit = 1;
            if(left == 2 || up == 2 || right == 2 || down == 2)
                toAtlantic = 2;
        }
        return toAtlantic + toPacifit;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{ 1,2,2,3,5 }, { 3,2,3,4,4 },
                { 2,4,5,3,1 }, { 6,7,1,4,5 }, { 5,1,1,2,4 }};
        Le417PacificAtlanticWaterFlow test = new Le417PacificAtlanticWaterFlow();
        test.pacificAtlantic(matrix);
    }
}
