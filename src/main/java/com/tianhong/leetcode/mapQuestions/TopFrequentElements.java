package com.tianhong.leetcode.mapQuestions;

import java.util.*;
// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]

public class TopFrequentElements {
    private class Freq {
        public int e, freq;
        // 频次越低， 优先级越高, 这样队列满了会先被删除
        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }
        // 方法1： 实现compareTo
//        @Override
//        public int compareTo(Freq another){
//            if(this.freq < another.freq)
//                return 1;
//            else if(this.freq > another.freq)
//                return -1;
//            else
//                return 0;
//        }
    }

    // 方法2， 使用比较器
//    private class FreqComparator implements Comparator<Freq> {
//        @Override
//        public int compare(Freq a, Freq b) {
//            return a.freq - b.freq;
//        }
//    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 计算得到带frequency的map
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(map) + 1);
            } else {
                map.put(num, 1);
            }
        }
        //  方法3， 使用匿名类
        PriorityQueue<Freq> queue = new PriorityQueue<>(new Comparator<Freq>() {
            @Override
            public int compare(Freq a, Freq b) {
                return a.freq - b.freq;
            }
        });
        for(int key : map.keySet()){
            if(queue.size() < k){
                queue.add(new Freq(key, map.get(key)));
            } else if (map.get(key) > queue.peek().freq) {
                queue.remove();
                queue.add(new Freq(key, map.get(key)));
            }
        }
        LinkedList<Integer> list = new LinkedList<>();
        while(!queue.isEmpty()){
            list.add(queue.remove().e);
        }
        return list;
    }
}
