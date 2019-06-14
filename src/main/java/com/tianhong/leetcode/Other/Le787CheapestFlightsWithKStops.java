package com.tianhong.leetcode.Other;

public class Le787CheapestFlightsWithKStops {
    private int total;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        total = Integer.MAX_VALUE;
        backTrack(flights, src, dst, K, 0, 0);
        return total == Integer.MAX_VALUE ? -1 : total;
    }

    public void backTrack(int[][] flights, int src, int dst, int K, int level, int price) {
        // 剪枝
        if(level > K + 1 || total != Integer.MAX_VALUE && price > total)
            return;
        if(src == dst && price < total) {
            total = price;
            return;
        }
        for(int i = 0; i < flights.length; i++) {
            int[] flight = flights[i];
            int s = flight[0];
            if(s == src) {
                int d = flight[1];
                int p = flight[2];
                backTrack(flights, d, dst, K, level + 1, price + p);
            }
        }
    }
}
