package com.tianhong.leetcode.arrayQuestions;

// Input: "Hello"
// Output: "hello"

// Input: "LOVELY"
// Output: "lovely"
public class ToLowerCase709 {
    public String toLowerCase(String str) {
        char[] charArray = str.toCharArray();
        for(int i = 0; i < charArray.length; i++){
            if(charArray[i] >= 'A'&& charArray[i] <= 'Z')
                charArray[i] = (char) (charArray[i] - 'A' + 'a');
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        ToLowerCase709 test = new ToLowerCase709();
        String ret = test.toLowerCase("Htetp");
        System.out.println(ret);

        System.out.println((int)'A');
        System.out.println((int)'B');
        System.out.println((int)'a');
        System.out.println((int)'b');
    }
}
