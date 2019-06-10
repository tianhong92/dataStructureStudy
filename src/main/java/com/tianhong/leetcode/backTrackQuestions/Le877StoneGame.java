package com.tianhong.leetcode.backTrackQuestions;

public class Le877StoneGame {
    public boolean stoneGame(int[] piles) {
        int sum = 0;
        for(int i : piles)
            sum += i;
        int total = sum / 2;
        return tryStealStone(piles, 1, piles.length - 1, piles[0], total, 1) ||
                tryStealStone(piles, 0, piles.length - 2, piles[piles.length - 1], total, 1);
    }

    public boolean tryStealStone(int[] p, int l, int r, int sum, int total, int level) {
        if(level >= p.length / 2) {
            if(sum > total) {
                return true;
            } else {
                return false;
            }
        }
        // second person get left one
        boolean left = tryStealStone(p, l + 1, r - 1, sum + p[r], total, level + 1) ||
                tryStealStone(p, l + 2, r, sum + p[l + 1], total, level + 1);

        // second person get right one
        boolean right = tryStealStone(p, l + 1, r - 1, sum + p[l], total, level + 1) ||
                tryStealStone(p, l, r - 2, sum + p[r - 1], total, level + 1);
        return left && right;

    }
}
