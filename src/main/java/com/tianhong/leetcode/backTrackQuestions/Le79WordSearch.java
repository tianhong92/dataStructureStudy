package com.tianhong.leetcode.backTrackQuestions;

// board =
// [
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
// ]
//
// Given word = "ABCCED", return true.
// Given word = "SEE", return true.
// Given word = "ABCB", return false.

public class Le79WordSearch {
    private char[][] chars = new char[][] {
        new char[] {'A', 'B', 'C', 'E'},
        new char[] {'S', 'F', 'C', 'S'},
        new char[] {'A', 'D', 'E', 'E'}
    };

        private boolean[][] taken;
        public boolean exist(char[][] board, String word) {
            if(word == null || word.equals("") || board == null || board.length == 0)
                return false;
            int x = board.length;
            int y = board[0].length;
            taken = new boolean[x][y];
            for(int i = 0; i < x; i++) {
                for(int j = 0; j < y; j++) {
                    if(searchWord(board, word.toCharArray(), i, j, 0))
                        return true;
                }
            }
            return false;
        }

        // start from 0;
        public boolean searchWord(char[][] board, char[] word, int x, int y, int start) {
            if(!validXY(x, y, board) || taken[x][y])
                return false;
            if(start == word.length - 1 && !taken[x][y] && word[start] == board[x][y]){
                return true;
            }
            if(board[x][y] == word[start]){
                taken[x][y] = true;
                if(searchWord(board, word, x + 1, y, start + 1) ||
                        searchWord(board, word, x - 1, y, start + 1) ||
                                searchWord(board, word, x, y + 1, start + 1) ||
                                    searchWord(board, word, x, y - 1, start + 1)) {
                    return true;

                }
                taken[x][y] = false;
            }
            return false;
        }

        public boolean validXY(int x, int y, char[][] board){
            if(x >=0 && y >=0 && x < board.length && y < board[0].length)
                return true;
            else
                return false;
        }


}
