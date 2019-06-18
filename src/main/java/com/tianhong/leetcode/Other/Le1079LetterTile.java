package com.tianhong.leetcode.Other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Le1079LetterTile {
    private Set<String> set;
    public int numTilePossibilities(String tiles) {
        set = new HashSet<>();
        backTrack(tiles.toCharArray(), new StringBuilder(), new boolean[tiles.length()]);
        return set.size();
    }


    public void backTrack(char[] cs, StringBuilder sb, boolean[] used) {
        if(sb.length() > 0 && sb.length() <= cs.length)
            set.add(new String(sb));
        for(int i = 0; i < cs.length; i++) {
            if(!used[i]) {
                sb.append(cs[i]);
                used[i] = true;
                backTrack(cs, sb, used);
                sb.deleteCharAt(sb.length() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String s = "AAB";
        Le1079LetterTile test = new Le1079LetterTile();
        test.numTilePossibilities(s);
        System.out.println(123);
    }
}
