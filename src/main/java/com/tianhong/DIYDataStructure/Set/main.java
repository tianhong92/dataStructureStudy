package com.tianhong.DIYDataStructure.Set;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        System.out.println("Pride and prejudice");
        ArrayList<String> word1 = new ArrayList<>();
        FileOperation.readFile("src/pride-and-prejudice.txt", word1);
        System.out.println(word1.size());

        BSTSet<String> set1 = new BSTSet<>();
        for(String word : word1)
            set1.add(word);
        System.out.println(set1.getSize());
    }
}


