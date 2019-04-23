package com.tianhong.leetcode.Other;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author TianhongWang
 * @since 2019/4/22
 */
public class Le417PacificAtlanticWaterFlow2 {

    private List<int[]> list = new ArrayList<>();
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if(matrix == null || matrix.length < 1)
            return list;
        int x = matrix.length;
        int y = matrix[0].length;

        boolean[][] reachAtlantic = new boolean[x][y];
        boolean[][] reachPacific = new boolean[x][y];
        // left atlantic
        for(int i = 0; i < x; i++) {
            reach(matrix, reachAtlantic, i, 0, matrix[i][0]);
        }
        // up atlantic
        for(int j = 1; j < y; j++) {
            reach(matrix, reachAtlantic, 0, j, matrix[0][j]);
        }
        // right pacific
        for(int k = 0; k < x; k++) {
            reach(matrix, reachPacific, k, y - 1, matrix[k][y-1]);
        }
        // bot pacific
        for(int l = 0; l < y - 1; l++){
            reach(matrix, reachPacific, x - 1, l, matrix[x-1][l]);
        }
        for(int t = 0; t < x; t++){
            for(int g = 0; g < y; g++){
                if(reachAtlantic[t][g] && reachPacific[t][g]){
                    list.add(new int[]{t, g});
                }
            }
        }
        return list;
    }

    public void reach(int[][] matrix, boolean[][] reachable, int x, int y, int pre) {
        if(!inBoard(matrix, x, y)){
            return;
        } else {
            if(reachable[x][y]) {
                return;
            } else if (matrix[x][y] >= pre) {
                reachable[x][y] = true;
            } else {
                return;
            }
        }
        reachable[x][y] = true;
        // up
        reach(matrix, reachable,x - 1, y, matrix[x][y]);
        // right
        reach(matrix, reachable, x, y + 1, matrix[x][y]);
        // down
        reach(matrix, reachable,x + 1, y, matrix[x][y]);
        // left
        reach(matrix, reachable, x, y - 1, matrix[x][y]);
    }

    public boolean inBoard(int[][] matrix, int x, int y){
        return x >= 0 && y >= 0 && x < matrix.length && y <matrix[0].length ? true : false;
    }

    public static void main(String[] args) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setRoundingMode(RoundingMode.HALF_UP);
        nf.setMinimumFractionDigits(0);//设置最小保留几位小数
        nf.setMaximumFractionDigits(0);
        Double tt = 25.6;
        Double rr = 25.4;
        System.out.println(nf.format(tt));
        System.out.println(nf.format(rr));

        Random r = new Random();
        System.out.println(String.valueOf(r.nextInt(100)));
    }
}
