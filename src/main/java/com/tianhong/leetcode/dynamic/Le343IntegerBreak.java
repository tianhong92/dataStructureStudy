package com.tianhong.leetcode.dynamic;

public class Le343IntegerBreak {
    private int maxProduct;
    public int integerBreak(int n) {
        if(n <= 2)
            return 1;
        backTrack(n, 1);
        return maxProduct;
    }

    public void backTrack(int n, int product) {
        if(n <= 2)
            return;
        for(int i = 1; i <= n; i++) {
            int temp = product * i * (n - i);
            if(temp > maxProduct)
                maxProduct = temp;
            backTrack(n - i, product * i);
        }
    }

    public static void main(String[] args) {
        Le343IntegerBreak test = new Le343IntegerBreak();
        test.integerBreak(6);
        System.out.println(test.maxProduct);
    }
}
