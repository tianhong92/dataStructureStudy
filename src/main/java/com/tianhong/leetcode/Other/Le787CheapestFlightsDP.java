package com.tianhong.leetcode.Other;

public class Le787CheapestFlightsDP {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] memo = new int[n][n];
        for(int i = 0; i < flights.length; i++) {
            int[] f = flights[i];
            int s = f[0];
            int d = f[1];
            int p = f[2];
            memo[s][d] = p;
        }
    }
}
