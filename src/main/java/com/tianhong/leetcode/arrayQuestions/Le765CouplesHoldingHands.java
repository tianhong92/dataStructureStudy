package com.tianhong.leetcode.arrayQuestions;

public class Le765CouplesHoldingHands {
    public int minSwapsCouples(int[] row) {
        int res = 0;
        for(int i = 0; i < row.length; i += 2) {
            if(row[i] == (row[i + 1] ^ 1)) {
                continue;
            }
            res++;
            for(int j = i + 1; j < row.length; j++) {
                if(row[i] == (row[j] ^ 1)) {
                    int temp = row[j];
                    row[j] = row[i + 1];
                    row[i + 1] = temp;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(1 ^ 1);
    }
}
