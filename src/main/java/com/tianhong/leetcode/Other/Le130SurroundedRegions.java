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
        boolean result1 = false, result2 = false, result3 = false, result4 = false;
        if(board[x][y] == 'O') {
            taken[x][y] = true;

            result1 = isSurrounded(board, x - 1, y, taken);
            result2 = isSurrounded(board, x + 1, y, taken);
            result3 = isSurrounded(board, x, y - 1, taken);
            result4 = isSurrounded(board, x, y + 1, taken);
        }
        return result1 && result2 && result3 && result4;
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
        char[][] cs = new char[][] {{'O', 'O', 'O', 'O', 'X', 'X'}, {'O', 'O', 'O', 'O', 'O', 'O'},
                                    {'O', 'X', 'O', 'X', 'O', 'O'}, {'O', 'X', 'O', 'O', 'X', 'O'},
                                    {'O', 'X', 'O', 'X', 'O', 'O'}, {'O', 'X', 'O', 'O', 'O', 'O'}};
        Le130SurroundedRegions test = new Le130SurroundedRegions();
        test.solve(cs);
    }

}
