package com.tianhong.leetcode.setQuestions;

// full table for the 26 letters of the English alphabet is given:
// [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---",
// "-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-",
// "...-",".--","-..-","-.--","--.."]

import java.util.HashMap;
import java.util.HashSet;

public class UniqueMorseCode {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        String[] codes = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....",
                "..",".---","-.-",".-..","--","-.","---", ".--.","--.-",".-.","...","-",
                "..-","...-",".--","-..-","-.--","--.."};
        HashMap<String, String> map = new HashMap<>();
        for(int i = 0; i < 26; i++){
            map.put(String.valueOf(i), codes[i]);
        }
        String[] words = new String[]{"dsf", "efdd", "qqq", "qqq"};
        for(String word : words){
            char[] charArray =  word.toCharArray();
            String temp = "";
            for(char c : charArray){
                map.get(c-'a');
                temp += c;;
            }
            set.add(temp);
        }
        System.out.println(set.size());
    }
}
