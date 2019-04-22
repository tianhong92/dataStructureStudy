package com.tianhong.leetcode.setQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Write an algorithm to determine if a number is "happy".
// A happy number is a number defined by the following process: Starting with any positive integer,
// replace the number by the sum of the squares of its digits, and repeat the process until the number
// equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for
// which this process ends in 1 are happy numbers.
//  Input: 19
//  Output: true
//  Explanation:
//  12 + 92 = 82
//  82 + 22 = 68
//  62 + 82 = 100
//  12 + 02 + 02 = 1
public class Le202HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        return happyTest(n, set);
    }

    public boolean happyTest(int n, Set<Integer> set){
        if(n == 0)
            return false;
        if(n == 1)
            return true;
        if(!set.add(n)){
            return false;
        }

        List<Integer> list = new ArrayList<>();
        int sum = 0;
        while(n > 0){
            list.add(n%10);
            n/=10;
        }
        for(int i : list){
            sum += (i*i);
        }
        return happyTest(sum, set);
    }

    public static void main(String[] args) {
        Le202HappyNumber test = new Le202HappyNumber();
        int num = 22;
        System.out.println(test.isHappy(num));
    }
}
