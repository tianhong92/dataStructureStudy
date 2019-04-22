package com.tianhong.leetcode.stackQuestions;

import java.util.Stack;

//Given a string containing just the characters '(' , ')' , '{' , '}' , '[' and ']' ,
//determine if the input string is valid.
public class ValidParentheses {
    public static boolean checkValidity(String input) {
        char[] chars = input.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(char x : chars) {
            if(x == '(' || x == '{' || x == '[') {
                stack.push(x);
            }
            if(x == ')' || x == '}' || x == ']') {
                if(stack.isEmpty()) {
                    return false;
                }
                char y = stack.pop();
                if( x == ')' && y != '(')
                    return false;
                else if (x == ']'  && y != '[')
                    return false;
                else if (x == '}' && y != '{')
                    return false;

            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(checkValidity("[(dfd]"));
    }
}
