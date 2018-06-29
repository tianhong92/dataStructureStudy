package com.tianhong.xiaoMA;

// input "student. a am I"
// output "I am a student."
public class ReverseSentence {

    public static String Reverse(String str) {
        if(str.length() == 0) {
            return "";
        }
        String[] strings = str.trim().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = strings.length -1; i >= 0; i--) {
            stringBuilder.append(strings[i]+" ");
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        String test = "student. a am I";
        System.out.println(Reverse(test));
    }


}
