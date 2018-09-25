package com.tianhong.leetcode.stackQuestions;

import com.tianhong.DIYDataStructure.Stack.ArrayStack;
import com.tianhong.DIYDataStructure.Stack.Stack;

//Given a string containing just the characters '(' , ')' , '{' , '}' , '[' and ']' ,
//determine if the input string is valid.
public class ValidParentheses {
    public static boolean checkValidity(String input) {
        char[] chars = input.toCharArray();
        Stack<Character> stack = new ArrayStack<>();

        for(char x : chars) {
            if(x == '(' || x == '{' || x == '[') {
                stack.push(x);
            }
            if(x == ')' || x == '}' || x == ']') {
                if(stack.isEmpty()) {
                    return false;
                }
                char y = stack.pop();
                if( x == '(' && y != ')')
                    return false;
                else if (x == '['  && y != ']')
                    return false;
                else if (x == '{' && y != '}')
                    return false;

            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkValidity("[(dfd)]"));
    }
}
