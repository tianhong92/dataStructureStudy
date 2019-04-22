package com.tianhong.leetcode.backTrackQuestions;

import java.util.ArrayList;
import java.util.List;

public class Le401BinaryWatch {

    private List<String> list = new ArrayList<>();
    public List<String> readBinaryWatch(int num) {
        if(num < 1) {
            list.add("0:00");
            return list;
        }
        for(int i = 0; i <= 11; i++) {
            for(int j = 0; j <= 59; j++) {
                if(Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i);
                    sb.append(":");
                    if(j <= 9)
                        sb.append("0");
                    sb.append(j);
                    list.add(sb.toString());
                }
            }
        }
        return list;
    }


}
