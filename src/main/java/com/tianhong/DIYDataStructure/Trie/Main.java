package com.tianhong.DIYDataStructure.Trie;

import com.tianhong.DIYDataStructure.Map.FileOperation;
import com.tianhong.DIYDataStructure.Set.BSTSet;

import java.util.ArrayList;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Pride and prejudice");
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("src/a-tale-of-two-cities.txt", words)){
            long startTime = System.currentTimeMillis();
            TreeSet<String> set = new TreeSet<>();
            for(String word : words)
                set.add(word);
            for(String word : words)
                set.contains(word);
            long endTime = System.currentTimeMillis();
            double time = (endTime - startTime)/1000.0;
            System.out.println("Total different words: "+set.size());
            System.out.println("Set: "+time+" s");

            long startTime2 = System.currentTimeMillis();
            Trie trie = new Trie();
            for(String word : words)
                trie.add(word);
            for(String word : words)
                trie.contains(word);
            long endTime2 = System.currentTimeMillis();
            double time2 = (endTime2 - startTime2)/1000.0;
            System.out.println("Total different words: "+trie.getSize());
            System.out.println("Trie: "+time2+" s");
        }

    }
}
