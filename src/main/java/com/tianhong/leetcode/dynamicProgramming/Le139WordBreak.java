package com.tianhong.leetcode.dynamicProgramming;

import java.util.List;

public class Le139WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() < 1)
            return false;
        return tryBreak(s, wordDict);
    }

    public boolean tryBreak(String s, List<String> word){
        if(s.length() == 0)
            return true;
        boolean ret1 = false;
        for(int i = 0; i < word.size(); i++) {
            String temp = word.get(i);
            int size = temp.length();
            if(s.length() >= size && s.substring(0,  size).equals(temp)){
                ret1 = tryBreak(s.substring(size, s.length()), word);
                if(ret1)
                    break;
            }
        }
        return ret1;
    }
}
