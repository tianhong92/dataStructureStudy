package com.tianhong.leetcode.stringQuestions;

/**
 * @author TianhongWang
 * @since 2019/2/15
 */
// Input: ["h","e","l","l","o"]
// Output: ["o","l","l","e","h"]
public class Le344ReverseString {
    public void reverseString(char[] s) {
        for(int i = 0; i < s.length/2; i++){
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i -1] = temp;
        }
    }

    public static void main(String[] args) {
        String str = "abcdef";
        char[] chars = str.toCharArray();
        Le344ReverseString test = new Le344ReverseString();
        test.reverseString(chars);
        System.out.println(chars);
    }
}
