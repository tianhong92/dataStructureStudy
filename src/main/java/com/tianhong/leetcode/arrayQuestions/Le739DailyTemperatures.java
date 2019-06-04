package com.tianhong.leetcode.arrayQuestions;

import java.util.Stack;

public class Le739DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] ret = new int[T.length];
        for(int i = 0; i < T.length; i++) {
            for(int j = i; j < T.length; j++) {
                if(T[j] > T[i]) {
                    ret[i] = j - i;
                    break;
                }
            }
        }
        return ret;
    }

    public int[] dailyTemperatures2(int[] T) {
        int[] ret = new int[T.length];
        int i = 0;
        int j = 1;
        while(i < T.length - 1) {
            if(j <= T.length - 1 && T[j] > T[i]) {
                ret[i] = j - i;
                i++;
                j = i + 1;
            } else if (j < T.length - 1) {
                j++;
            } else {
                i++;
                j = i + 1;
            }
        }
        return ret;
    }

    public int[] dailyTemperatures3(int[] T) {
        int[] ret = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < T.length; i++) {
            while(!stack.empty() && T[i] > T[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }
        return ret;
    }

}
