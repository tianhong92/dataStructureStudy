package com.tianhong.xiaoMA;

import java.util.ArrayList;
import java.util.List;

// 循环左移
// 输入 abcdefg 循环左移3位得到 defgabc
public class LeftRotateString {
    public static String leftRotate(String str, int steps) {
        if(steps < 0 || steps > str.length()) {
            throw new IllegalArgumentException("Argument steps should >= 0 and <= str.length.");
        }
        if(str.length() == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        char[] chars = str.toCharArray();
        for(int i = steps; i < str.length(); i++) {
           sb.append(chars[i]);
        }
        for(int j = 0; j < steps; j++) {
            sb.append(chars[j]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "";
        System.out.println(leftRotate(str, 0));

    }
}
