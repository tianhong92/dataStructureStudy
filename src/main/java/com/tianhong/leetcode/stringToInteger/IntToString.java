package com.tianhong.leetcode.stringToInteger;

/**
 * @author TianhongWang
 * @since 2019/2/15
 */
public class IntToString {
    public String intToString(int n){
        StringBuilder s = new StringBuilder();
        while(n != 0){
            s.append(n%10);
            n /= 10;
        }
        s.reverse();
        return s.toString();
    }

    public static void main(String[] args) {
        IntToString test = new IntToString();
        System.out.println(test.intToString(12345));
    }
}
