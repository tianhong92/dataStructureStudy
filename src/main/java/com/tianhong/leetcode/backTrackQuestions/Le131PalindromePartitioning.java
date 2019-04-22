package com.tianhong.leetcode.backTrackQuestions;

import java.util.ArrayList;
import java.util.List;

//  Input: "aab"
//  Output:
//  [
//      ["aa","b"],
//      ["a","a","b"]
//  ]

public class Le131PalindromePartitioning {
    List<List<String>> ret = new ArrayList<>();
    public List<List<String>> partition(String s) {
        getOne(new ArrayList<>(), s.toCharArray(), "", 0, 0);
        return ret;
    }

    public void getOne(List<String> list, char[] chars, String temp, int count, int index){
        if(isPalin(temp)){
            list.add(temp);
            count += temp.length();
        } else {
            return;
        }
        if(count == chars.length) {
            ret.add(list);
            return;
        }
        for(int i = 0; i < chars.length; i++){
            if(i + index < chars.length) {
                temp += chars[i];
                getOne(list, chars, temp, count, i + index + 1);
            }
        }
    }

    public boolean isPalin(String str){
        if(str == null || str.length() == 0)
            return false;
        if(str.length() == 1)
            return true;
        int i = 0;
        int j = str.length() - 1;
        while(i < j){
            if(str.charAt(i) != str.charAt(j))
                return false;
            else {
                i++;
                j--;
            }
        }
        return true;
    }
}
