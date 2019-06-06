package com.tianhong.leetcode.Other;

import java.util.*;

public class Le406QueueReconstruction {
    public int[][] reconstructQueue(int[][] people) {
        if (people.length <= 1)
            return people;
        List<int[]> ret = new ArrayList<>();
        Arrays.sort(people,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        for(int[] cur : people){
            ret.add(cur[1],cur);
        }
        return ret.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        int[][] people = new int[][] {{8,2}, {4,2},{4,5},{2,0},{7,2},{1,4},{9,1},{3,1},{9,0},{1,0}};
        Le406QueueReconstruction test = new Le406QueueReconstruction();
        test.reconstructQueue(people);
        System.out.println(123);
    }
}
