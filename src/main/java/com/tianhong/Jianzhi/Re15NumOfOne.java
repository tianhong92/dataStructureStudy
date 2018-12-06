package com.tianhong.Jianzhi;

/**
 * @Author: TianhongWang
 * @Date: 2018/12/6
 * @Description
 */
public class Re15NumOfOne {
    // n :       10110100
    // n-1:      10110011
    // n&(n-1):  10110000

    public static int NumberOfOne(int n){
        int count = 0;
        while(n != 0){
            count++;
            n &= (n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOfOne(21));
        System.out.println(Integer.bitCount(21));
    }
}
