package com.tianhong.leetcode.Other;

public class Le130SurroundedRegions {

    private boolean[][] taken;
    public void solve(char[][] board) {
        if(board == null || board.length < 3 || board[0].length < 3)
            return;
        int x = board.length;
        int y = board[0].length;
        taken = new boolean[x][y];
        for(int i = 1; i < x - 1; i++) {
            for(int j = 1; j < y - 1; j++) {
                if(!taken[i][j] && board[i][j] == 'O' && isSurrounded(board, i, j, taken)){
                    System.out.println("i = " + i + "j = "+j);
                    flip(board, i, j);
                }
            }
        }
    }

    public boolean isSurrounded(char[][] board, int x, int y, boolean[][] taken) {
        if(!inBoard(board, x, y))
            return false;
        if(board[x][y] == 'X' || taken[x][y])
            return true;
        boolean result = false;
        if(board[x][y] == 'O') {
            taken[x][y] = true;
            result = isSurrounded(board, x - 1, y, taken) && isSurrounded(board, x + 1, y, taken)
                    && isSurrounded(board, x, y - 1, taken) && isSurrounded(board, x, y + 1, taken);
        }
        return result;
    }

    public void flip(char[][] board, int x, int y) {
        if(!inBoard(board, x, y) || board[x][y] == 'X')
            return;
        board[x][y] = 'X';
        flip(board, x - 1, y);
        flip(board, x + 1, y);
        flip(board, x, y - 1);
        flip(board, x, y + 1);
    }

    public boolean inBoard(char[][] board, int x, int y) {
        if(x >= 0 && y >= 0 && x < board.length && y < board[0].length)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        char[][] cs = new char[][] {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        Le130SurroundedRegions test = new Le130SurroundedRegions();
        test.solve(cs);
        System.out.println("sdfd");
    }

}
