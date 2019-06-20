package com.tianhong.leetcode.Other;

import java.util.Stack;

public class Le402RemoveKDigits {

    public String removeKdigits(String num, int k) {
        //要拿size个
        int size = num.length() - k;
        if(size < 1)
            return "0";

        String ret = getMin(num.toCharArray(), new StringBuilder(), 0, num.length() - size, size);
        int i = 0;
        for(int j = 0; j < ret.length(); j++){
            if(ret.charAt(j) == '0') {
                i++;
            } else {
                break;
            }
        }
        String r = ret.substring(i, ret.length());
        return r == "" ? "0" : r;
    }

    public String getMin(char[] cs, StringBuilder sb, int i, int j, int level) {
        if(level == sb.length()) {
            return sb.toString();
        }
        int index = 0;
        char min = cs[i];
        for(int k = i; k <= j; k++) {
            if(cs[k] < min) {
                min = cs[k];
                index = k;
            }
        }
        sb.append(min);
        i = index + 1;
        j = cs.length - level + sb.length();
        return getMin(cs, sb, i, j, level);
    }


    // Greedy + Stack
    public String removeKdigits2(String num, int k) {
        if(k >= num.length()) {
            return "0";
        }
        char[] cs = num.toCharArray();
        Stack<Character> stack = new Stack();
        for(int i = 0; i < cs.length; i++) {
            if(!stack.empty() && k > 0 && cs[i] < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(cs[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < stack.size(); i++) {
            sb.append(stack.pop());
        }
        String s = sb.reverse().toString();
        String ret = null;
        int count = 0;
        for(int i = 0; i < sb.length(); i++) {
            if(s.charAt(i) == '0') {
                count++;
            }
        }
        ret = s.substring(count, s.length());
        if(s.length() == num.length()) {
            ret = s.substring(k, s.length());
        }
        return ret;
    }

}
