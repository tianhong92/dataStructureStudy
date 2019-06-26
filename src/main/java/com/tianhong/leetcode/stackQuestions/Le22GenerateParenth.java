package com.tianhong.leetcode.stackQuestions;

import java.util.ArrayList;
import java.util.List;

public class Le22GenerateParenth {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n < 1)
            return list;
        backTrack(list, new StringBuilder(), 0, 0, n);
        return list;
    }

    public void backTrack(List<String> list, StringBuilder sb, int left, int right, int n) {
        if(sb.length() == n * 2) {
            list.add(sb.toString());
            return;
        }

        if(left < n) {
            sb.append('(');
            backTrack(list, sb, left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(left > right) {
            sb.append(')');
            backTrack(list, sb, left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
