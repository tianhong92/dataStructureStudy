package com.tianhong.leetcode.arrayQuestions;
// 回文串
// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
// Note: For the purpose of this problem, we define empty string as valid palindrome.

// Input: "A man, a plan, a canal: Panama"
// Output: true

// Input: "race a car"
// Output: false

public class Le125ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s.length() <= 1){
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        s = s.toLowerCase();
        while(i < j){
            if(!validAlphaNumeric(s.charAt(i))){
                i++;
            } else if(!validAlphaNumeric(s.charAt(j))){
                j--;
            } else if (s.charAt(i) != s.charAt(j)){
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public boolean validAlphaNumeric(char c){
        if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
            return true;
        }
        if(c >= '0' && c <= '9'){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //String str =  "A man, a plan, a canal: Panama";
        String str = "0P";
        Le125ValidPalindrome test = new Le125ValidPalindrome();
        System.out.println(test.isPalindrome(str));
    }
}
