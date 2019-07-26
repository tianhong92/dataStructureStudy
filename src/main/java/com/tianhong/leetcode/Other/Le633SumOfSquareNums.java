package com.tianhong.leetcode.Other;

public class Le633SumOfSquareNums {
    public boolean judgeSquareSum(int c) {
        if(c == 0)
            return true;
        for(int i = 0; i * i < c; i++) {
            Double res = Math.pow(c - i * i, 0.5);
            if(res - res.intValue() == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Le633SumOfSquareNums test = new Le633SumOfSquareNums();
        test.judgeSquareSum(0);
    }

}
