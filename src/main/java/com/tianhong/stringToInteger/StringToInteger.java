package com.tianhong.stringToInteger;

// implement function to convert a string to an integer
// input = {'0123', '+454', '-879'. ' +872', '  -878'}
public class StringToInteger {
    public static int atoi(String str) {
        boolean flag = true; // 正负
        Long result = 0l;
        int startIndex = 0;
        int length = str.length();
        char[] chars = str.toCharArray();

        for(int i = 0; i < length; i++) {
            char current = chars[i];
            if(startIndex == i) {
                if(current == ' ') {
                    startIndex++;
                    continue;
                }
                if(current == '+') {
                    continue;
                }
                if(current == '-') {
                    flag = false;
                    continue;
                }
            }

            result = result*10 + current;

        }
        return 0;
    }

    public static void main(String[] args) {
        ;
    }

}
