package com.tianhong.leetcode.mapQuestions;


import java.util.HashMap;
import java.util.Map;

//Definition for a point.
class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}
// Input: [[1,1],[2,2],[3,3]]
// Output: 3
public class Le149MaxPointsOnALine {

    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0)
            return 0;
        if(points.length == 1)
            return 1;
        Map<Double, Integer> map = new HashMap<>();
        int maxLength = 0;
        int samePoint = 0;
        for(int i = 0; i < points.length; i++){
            for(int j = 0; j < points.length; j++){
                if(i == j)
                    continue;
                double slope = getSlope(points[i], points[j]);
                if(slope == 0){
                    samePoint++;
                } else {
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                }
            }
            for(int x : map.values()){
                if(x + samePoint> maxLength)
                    maxLength = x + samePoint;
            }
            samePoint = 0;
            map.clear();
        }
        return maxLength + 1;
    }

    public double getSlope(Point a, Point b){
        return (double) (b.y - a.y) / (double) (b.x - a.x);
    }

    public static void main(String[] args) {
        Point a = new Point(2, 3);
        Point b = new Point(5, 11);
        double ret = new Le149MaxPointsOnALine().getSlope(a, b);
        System.out.println(ret);
    }

}
