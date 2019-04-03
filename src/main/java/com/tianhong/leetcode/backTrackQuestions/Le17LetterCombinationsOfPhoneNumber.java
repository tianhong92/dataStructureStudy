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
        char[] cs = digits.toCharArray();
        backTrack("", cs, 0);
        return list;
    }

    public void backTrack(String combination, char[] digits, int index){
        if(index == digits.length) {
            list.add(combination);
            return;
        }
        String str = strings[digits[index] - '2'];
        for(char c : str.toCharArray()){
            backTrack(combination + String.valueOf(c), digits, index + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println('7' - '2');
    }
}
