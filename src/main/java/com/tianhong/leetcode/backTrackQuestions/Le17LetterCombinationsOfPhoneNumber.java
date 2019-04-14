package com.tianhong.leetcode.backTrackQuestions;

import java.util.ArrayList;
import java.util.List;

public class Le17LetterCombinationsOfPhoneNumber {
    private List<String> list = new ArrayList<>();
    private static String[] strings = new String[]{
            "abc",      // ---> 2
            "def",      // ---> 3
            "ghi",      // ---> 4
            "jkl",      // ---> 5
            "mno",      // ---> 6
            "pqrs",     // ---> 7
            "tuv",      // ---> 8
            "wxyz"      // ---> 9
    };

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return list;
        backTrack(new StringBuilder(), digits.toCharArray(), 0);
        return list;
    }

    public void backTrack(StringBuilder sb, char[] digits, int index){
       if(index == digits.length) {
           list.add(sb.toString());
           return;
       }
       char[] cs = strings[digits[index] - '2'].toCharArray();
       for(int i = 0; i < cs.length; i++) {
           sb.append(cs[i]);
           backTrack(sb, digits, index + 1);
           sb.delete(sb.length() - 1, sb.length());
       }
    }

    public static void main(String[] args) {
        String digits = "234";
        Le17LetterCombinationsOfPhoneNumber test = new Le17LetterCombinationsOfPhoneNumber();
        test.letterCombinations(digits);
        System.out.println(test.list);
    }
}
