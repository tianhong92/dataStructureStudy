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
        if(s == null || s.length() < 4)
            return list;
        backTrack(new StringBuilder(), 0, s, 0);
        return list;
    }

    public void backTrack(StringBuilder sb, int index, String s, int level) {
        if(index > s.length()) {
            return;
        }
        if(level == 4) {
            if(index == s.length())
                list.add(sb.toString());
            return;
        }
        for(int i = 1; i <= 3; i++) {
            if(index + i > s.length())
                break;
            if(validAddress(s.substring(index, index + i))) {
                sb.append(s.substring(index, index + i));
                if (level < 3)
                    sb.append(".");
                backTrack(sb, index + i, s, level + 1);
                if (level < 3)
                    sb.delete(sb.length() - 1, sb.length());
                sb.delete(sb.length() - i, sb.length());
            }
        }

    }


    public boolean validAddress(String s) {
        if(s.length() == 0)
            return false;
        int num = Integer.valueOf(s);
        int size = s.length();
        if(size == 1 || (size == 2 && num >= 10 && num <= 99) || (size == 3 && num >= 100 && num <= 255))
            return true;
        else
            return false;
    }


    public List<String> restoreIpAddresses2(String s) {
        if(s.length() < 4)
            return list;
        String s1 = "", s2 = "", s3 = "", s4 = "";
        for(int i = 0; i < 3; i++) {
            for(int j = i + 1; j <= i + 3; j++){
                for(int k = j + 1; k <= j + 3; k++) {
                    for(int g = k + 1; g <= k + 3; g++) {
                        if(g == s.length() - 1){
                            s1 = s.substring(0, i + 1);
                            s2 = s.substring(i + 1, j + 1);
                            s3 = s.substring(j + 1, k + 1);
                            s4 = s.substring(k + 1, g + 1);
                            if(validAddress(s1) && validAddress(s2) && validAddress(s3) && validAddress(s4)){
                                list.add(s1 + "." + s2 + "." + s3 + "."+ s4);
                            }
                        }
                    }
                }
            }
        }
        return list;
    }

}
