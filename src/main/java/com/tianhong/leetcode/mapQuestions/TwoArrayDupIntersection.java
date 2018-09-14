package com.tianhong.leetcode.mapQuestions;

import java.util.ArrayList;
import java.util.HashMap;

// input: num1 = [1, 2, 2, 6, 1]; num2 = [2, 2]
// output: [2, 2]
public class TwoArrayDupIntersection {
    public static int[] intersect(int[] num1, int[] num2){
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : num1){
            if(!map.containsKey(num)){
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        for(int num : num2){
            if(map.containsKey(num)){
                list.add(num);
                if(map.get(num) == 1){
                    map.remove(num);
                } else {
                    map.put(num, map.get(num) - 1);
                }
            }
        }

        int[] ret = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ret[i] = list.get(i);
        }
        return ret;

    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 2, 6, 1};
        int[] num2 = {1, 1, 2, 2, 2};
        int[] ret = intersect(num1, num2);
        System.out.print("[ ");
        for(int i = 0; i < ret.length; i++){
            if(i == ret.length - 1){
                System.out.print(ret[i]+" ]");
            } else {
                System.out.print(ret[i]+", ");
            }
        }
    }
}
