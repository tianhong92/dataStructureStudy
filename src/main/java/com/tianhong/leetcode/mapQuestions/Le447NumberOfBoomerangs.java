package com.tianhong.leetcode.mapQuestions;

import java.util.HashMap;
import java.util.Map;

// Given n points in the plane that are all pairwise distinct,
// a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j
// equals the distance between i and k (the order of the tuple matters).
//
// Find the number of boomerangs. You may assume that n will be at most 500 and coordinates
// of points are all in the range [-10000, 10000] (inclusive).
// Input:
//[[0,0],[1,0],[2,0]]
//
// Output:
// 2
//
// Explanation:
// The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
public class Le447NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        if(points.length < 3){
            return 0;
        }
        int res = 0;

        for(int i = 0; i < points.length; i++){
            Map<Integer, Integer> map = new HashMap<>();
            for(int j = 0; j < points.length; j++){
                if(i != j){
                    int d = getDistance(points[i], points[j]);
                    map.put(d, map.getOrDefault(d, 0) + 1);
                }
            }
            for(int val : map.values()){
                res += val*(val-1);
            }
        }
        return res;
    }

    public int getDistance(int[] a, int[] b){
        return (b[0] - a[0]) * (b[0] - a[0]) + (b[1] - a[1]) * (b[1] - a[1]);
    }


}
