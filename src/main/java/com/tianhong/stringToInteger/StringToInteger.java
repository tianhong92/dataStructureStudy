package com.tianhong.stringToInteger;

// implement function to convert a string to an integer
// input = {'0123', '+454', '-879'. ' +872', '  -878'}
public class StringToInteger {
    public static int atoi(String str) {
        boolean flag = true; // 正负
        Long result = 0l;
        int startIndex = 0;
        int length = 0; //整数的实际长度
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
            if(current >= '0' && current <= '9') {
                result = result * 10 + ( current - '0'); //哇！ 原来-'0'可以将字符转int类型
                length++;
                if(length > 10) {
                    break;
                }
            } else {
                break;
            }

        }

        if(result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if(result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return result.intValue();
    }

    public static void main(String[] args) {
        //Long result = 0L;
        //result = result*10+'8'-'0';
        System.out.println(Integer.MIN_VALUE);
    }

}
