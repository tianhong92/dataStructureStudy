package com.tianhong.DIYDataStructure.Set;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        //**************** BSTSet ***************
        System.out.println("Pride and prejudice");
        ArrayList<String> word1 = new ArrayList<>();
        FileOperation.readFile("src/pride-and-prejudice.txt", word1);
        System.out.println(word1.size());

        BSTSet<String> set1 = new BSTSet<>();
        for(String word : word1)
            set1.add(word);
        System.out.println(set1.getSize());


        //***************** LinkedListSet ***************

        LinkedListSet<String> set2 = new LinkedListSet<>();
        for(String word : word1)
            set2.add(word);
        System.out.println(set2.getSize());
    }
}


