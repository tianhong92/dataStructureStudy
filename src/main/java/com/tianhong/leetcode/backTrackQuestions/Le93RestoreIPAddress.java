package com.tianhong.leetcode.backTrackQuestions;

import java.util.List;

// Given a string containing only digits, restore it by returning all possible
// valid IP address combinations.

// Input: "25525511135"
// Output: ["255.255.11.135", "255.255.111.35"]

// A类： 1.0.0.0 - 126.255.255.255
// B类： 128.0.0.0 - 191.255.255.255
// C类： 192.0.0.1 - 223.255.255.255
// 每一位0-255之间就是合法的

public class Le93RestoreIPAddress {
    private List<String> list;
    public List<String> restoreIpAddresses(String s) {
        if(s.length() < 4)
            return list;
        backTrack("", s.toCharArray(), 0, 0);
        return list;
    }

    public void backTrack(String combination, char[] chars, int index, int count){
        if(count == 4 && combination.length() == chars.length + 3) {
            list.add(combination);
            return;
        }
        if(count == 4)
            return;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 3; i++){
            sb.append(chars[i+index]);
            if(Integer.valueOf(sb.toString()) <= 255){
                if(count < 3) {
                    backTrack(combination += sb.toString() + ".", chars, index + i + 1, count + 1);
                } else {
                    backTrack(combination += sb.toString(), chars, index + i + 1, count + 1);
                }
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        String a = "25525511135";
        Le93RestoreIPAddress test = new Le93RestoreIPAddress();
        List<String> ret = test.restoreIpAddresses(a);
        System.out.println(ret);
    }
}
