package com.tianhong.leetcode.Other;

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

    public static void main(String[] args) {
        String s = "10";
        Le402RemoveKDigits test = new Le402RemoveKDigits();
        String b = test.removeKdigits(s, 2);
        System.out.println(b);
    }

}
