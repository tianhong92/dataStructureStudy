package com.tianhong.DIYDataStructure.Set;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        System.out.println("Pride and prejudice");
        ArrayList<String> word1 = new ArrayList<>();
        FileOperation.readFile("com/tianhong/DIYDataStructure/Set/pride-and-prejudice.txt", word1);
        System.out.println(word1.size());
    }
}


