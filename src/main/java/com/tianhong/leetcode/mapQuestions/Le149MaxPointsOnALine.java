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
        int sameX = 0;
        int sameY = 0;
        for(int i = 0; i < points.length; i++){
            for(int j = 0; j < points.length; j++){
                if(points[i].x == points[j].x && points[i].y == points[j].y)
                    samePoint++;
                else if(points[i].x != points[j].x && points[i].y == points[j].y)
                    sameY++;
                else if(points[i].x == points[j].x && points[i].y != points[j].y)
                    sameX++;
                else {
                    double slope = getSlope(points[i], points[j]);
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                }
            }
            for(int x : map.values()){
                if(x + samePoint> maxLength)
                    maxLength = x + samePoint;
            }
            if(samePoint + sameX > maxLength)
                maxLength = samePoint + sameX;
            if(samePoint + sameY > maxLength)
                maxLength = samePoint + sameY;
            samePoint = 0;
            sameX = 0;
            sameY = 0;
            map.clear();
        }
        return maxLength;
    }

    public double getSlope(Point a, Point b){
        return (double) ((b.y - a.y) / (b.x - a.x));
    }


    public int maxPoints2(Point[] points) {
        if (points==null) return 0;
        if (points.length<=2) return points.length;

        Map<Integer,Map<Integer,Integer>> map = new HashMap<Integer,Map<Integer,Integer>>();
        int result=0;
        for (int i=0;i<points.length;i++){
            map.clear();
            int overlap=0,max=0;
            for (int j=i+1;j<points.length;j++){
                int x=points[j].x-points[i].x;
                int y=points[j].y-points[i].y;
                if (x==0&&y==0){
                    overlap++;
                    continue;
                }
                int gcd=generateGCD(x,y);
                if (gcd!=0){
                    x/=gcd;
                    y/=gcd;
                }

                if (map.containsKey(x)){
                    if (map.get(x).containsKey(y)){
                        map.get(x).put(y, map.get(x).get(y)+1);
                    }else{
                        map.get(x).put(y, 1);
                    }
                }else{
                    Map<Integer,Integer> m = new HashMap<Integer,Integer>();
                    m.put(y, 1);
                    map.put(x, m);
                }
                max=Math.max(max, map.get(x).get(y));
            }
            result=Math.max(result, max+overlap+1);
        }
        return result;


    }
    private int generateGCD(int a,int b){

        if (b==0) return a;
        else return generateGCD(b,a%b);

    }


    public static void main(String[] args) {
        Point a1 = new Point(0, 0);
        Point a2 = new Point(94911151, 94911150);
        Point a3 = new Point(94911152, 94911151);
//        Point a4 = new Point(4, 1);
//        Point a5 = new Point(2, 3);
//        Point a6 = new Point(1, 4);
        Point[] points = new Point[]{a1, a2, a3};
        Le149MaxPointsOnALine test = new Le149MaxPointsOnALine();
        test.maxPoints(points);

    }

}
