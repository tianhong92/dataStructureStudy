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
        String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        HashMap<String, String> map = new HashMap<>();
        for(int i = 0; i < 26; i++){
            map.put(codes[i], letters[i]);
        }
        String[] words = new String[]{"dsf", "efdd", "qqq", "eret"};
        for(String word : words){
            char[] charArray =  word.toCharArray();
            String temp = "";
            for(char c : charArray){
                map.get(c);
                temp += c;;
            }
            set.add(temp);
        }
        System.out.println(set.size());
    }
}
