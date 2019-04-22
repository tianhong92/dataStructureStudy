package com.tianhong.leetcode.backTrackQuestions;

import java.util.ArrayList;
import java.util.List;


//  Input: n = 4, k = 2
//  Output:
//  [
//      [2,4],
//      [3,4],
//      [2,3],
//      [1,2],
//      [1,3],
//      [1,4],
//  ]

public class Le77Combinations {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(n < 1 || k < 1 || k > n){
            return list;
        }
        backTrack(n, k, new ArrayList<>(), 1);
        return list;
    }

    // 1...n中找k个数的组合， 组合暂时存l里面， start表示组合起点
    public void backTrack(int n, int k, List<Integer> l, int start) {
        if (l.size() == k) {
            list.add(new ArrayList<>(l));
            System.out.println("Added list = " + l + " return");
            return;
        }
        for (int i = start; i <= n; i++) {
            System.out.println("i = " + i + " start = " + start);
            l.add(i);
            System.out.println("list = " + l);
            backTrack(n, k, l, i + 1);
            System.out.println("Remove " + l.get(l.size() - 1));
            l.remove(l.size() - 1);
        }
        System.out.println("End start = "+ start);
    }

    public static void main(String[] args) {
        Le77Combinations test = new Le77Combinations();
        test.combine(4, 2);
    }
}
