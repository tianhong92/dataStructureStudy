package com.tianhong.leetcode.Other;

public class Le7ReverseInteger {
    public int reverse(int x) {
        long ret = 0;
        while(x != 0) {
            ret = ret * 10 + x % 10;
            x /= 10;
        }
        if(ret < Integer.MIN_VALUE || ret > Integer.MAX_VALUE) {
            return 0;
        }
        return (int)ret;
    }

    public static void main(String[] args) {
        int x = Integer.MIN_VALUE - 1;
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(x);
    }
}
