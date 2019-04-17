package com.tianhong.leetcode.Other;

// Input: 11111111111111111111111111111101
// Output: 31
// Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.

public class Le191NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            count = count + n & 1;
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int i = 00010;
        System.out.println(i);
        System.out.println(Integer.bitCount(i));

        System.out.println(0xffffffff);
    }
}
