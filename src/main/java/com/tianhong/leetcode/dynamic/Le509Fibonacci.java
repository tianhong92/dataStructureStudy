package com.tianhong.leetcode.dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TianhongWang
 * @since 2019/4/23
 */
public class Le509Fibonacci {

    // 自上而下

    public int fib(int N) {
       int[] sum = new int[N + 1];
       return dynamic(sum, N);
    }

    public int dynamic(int[] sum, int N) {
       if(N <= 1)
           return N;
       else if (sum[N] == 0) {
           sum[N] = dynamic(sum, N - 1) + dynamic(sum, N - 2);
       }
       return sum[N];
    }

    // 自下而上
    public int fib2(int N) {
        int[] sum = new int[N + 1];
        return dynamic2(sum, N);
    }

    public int dynamic2(int[] sum, int N) {
        if(N <= 1){
            sum[N] = N;
            return N;
        }
        sum[0] = 0;
        sum[1] = 1;
        for(int i = 2; i <= N; i++) {
            sum[i] = sum[i - 1] + sum[i - 2];
        }
        return sum[N];
    }

    public static void main(String[] args) {
        Le509Fibonacci test = new Le509Fibonacci();
        test.fib(2);
    }
}
