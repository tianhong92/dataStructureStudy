package com.tianhong.leetcode.backTrackQuestions;

import java.util.ArrayList;
import java.util.List;

// Given a string containing only digits, restore it by returning all possible
// valid IP address combinations.

// Input: "25525511135"
// Output: ["255.255.11.135", "255.255.111.35"]

// A类： 1.0.0.0 - 126.255.255.255
// B类： 128.0.0.0 - 191.255.255.255
// C类： 192.0.0.1 - 223.255.255.255
// 每一位0-255之间就是合法的

//    public List<String> restoreIpAddresses(String s) {
//        List<String> list = new LinkedList<>();
//        backtrack(s,list,new StringBuilder(),0,0);
//        return list;
//    }
//    private void backtrack(String s, List<String> list, StringBuilder sb, int index, int level){
//        if(index > s.length() || level > 4) return;
//        else if(index == s.length() && level == 4){
//            list.add(sb.toString());
//            return;
//        }
//        for(int i = 1;i <= 3;i++){
//            if(index+i > s.length()) break;
//            int num = Integer.valueOf(s.substring(index,index+i));
//            if(i == 1 || i==2 && num >=10 && num <=99 || i == 3 && num >= 100 && num <= 255){
//                sb.append(num);
//                if(level < 3) sb.append(".");
//                backtrack(s,list,sb,index+i,level+1);
//                if(level < 3) sb.deleteCharAt(sb.length()-1);
//                sb.delete(sb.length()-i,sb.length());
//            }
//        }
//    }

public class Le93RestoreIPAddress {
    private List<String> list = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if(s.length() < 4)
            return list;
        backTrack(s, new StringBuilder(), 0, 0);
        return list;
    }

    public void backTrack(String s, StringBuilder sb, int index, int level) {
        if(index > s.length() || level > 4)
            return;
        if(level == 4 && index == s.length()){
            list.add(sb.toString());
            return;
        }
        for(int i = 1; i <= 3; i++){
            int num = Integer.valueOf(s.substring(index, index + i));
            if(i == 1 || (i == 2 && i >= 10 && i <= 99) || (i == 3 && i >= 100 && i <= 255)) {
                sb.append(num);
                if(level < 3)
                    sb.append(".");
                backTrack(s, sb, index + i, level + 1);
                if(level < 3)
                    sb.delete(sb.length() - 1, sb.length());
                sb.delete(sb.length() - i, sb.length());
            }
        }
    }


//    public static void main(String[] args) {
//        String s = "25525511135";
//        Le93RestoreIPAddress test = new Le93RestoreIPAddress();
//        System.out.println(test.restoreIpAddresses(s));
//    }
}
