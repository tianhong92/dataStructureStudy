package com.tianhong.leetcode.stackQuestions;

// Valid operators are +, -, *, /. Each operand may be an integer or another expression.

// Input: ["2", "1", "+", "3", "*"]
// Output: 9
// Explanation: ((2 + 1) * 3) = 9

// Input: ["4", "13", "5", "/", "+"]
// Output: 6
// Explanation: (4 + (13 / 5)) = 6

import java.util.Stack;

public class Le150EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        String s1;
        String s2;
        String res;
        if(tokens == null || tokens.length == 0)
            return 0;
        for(String token : tokens) {
            if(token.equals("+")) {
                s1 = stack.pop();
                s2 = stack.pop();
                res = String.valueOf(Integer.valueOf(s1) + Integer.valueOf(s2));
                stack.push(res);
            } else  if (token.equals("-")){
                s1 = stack.pop();
                s2 = stack.pop();
                res = String.valueOf(Integer.valueOf(s2) - Integer.valueOf(s1));
                stack.push(res);
            } else if (token.equals("*")){
                s1 = stack.pop();
                s2 = stack.pop();
                res = String.valueOf(Integer.valueOf(s2) * Integer.valueOf(s1));
                stack.push(res);
            } else if (token.equals("/")){
                s1 = stack.pop();
                s2 = stack.pop();
                res = String.valueOf(Integer.valueOf(s2) / Integer.valueOf(s1));
                stack.push(res);
            } else {
                stack.push(token);
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
