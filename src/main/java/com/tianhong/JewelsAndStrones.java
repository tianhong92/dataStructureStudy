package com.tianhong;

public class JewelsAndStrones {
    public static int jewelsCount(String J, String S) {
        char[] jewels = S.toCharArray();
        int count = 0;
        for(int i = 0; i < jewels.length; i++) {
            String temp = String.valueOf(jewels[i]);
            if(J.indexOf(temp) != -1) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int count = jewelsCount("aA", "AAddfa");
        System.out.println("Count: "+count);
    }
}
