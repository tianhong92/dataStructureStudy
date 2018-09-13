package com.tianhong.DIYDataStructure.Map;

import java.util.ArrayList;

public class LinkedListMap<K, V> implements Map<K, V> {
    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key){ this(key, null, null); }
        public Node(){ this(null, null, null); }

        @Override
        public String toString(){
            return key.toString()+" : "+value.toString();
        }
    }
    private Node dummyHead;
    private int size;
    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        // key是唯一的
        Node node = getNode(key);
        if(node == null){
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node cur = dummyHead;
        while(cur.next != null){
            if(cur.next.key.equals(key)){
                Node removeNode = cur.next;
                cur.next = removeNode.next;
                size --;
                return removeNode.value;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if(node != null){
            node.value = value;
        } else {
            throw new IllegalArgumentException(key + "doesn't exist!");
        }
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V get(K key){
        Node res = getNode(key);
        return res == null ? null : res.value;
    }
    private Node getNode(K key){
        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.key.equals(key))
                return cur;
            cur = cur.next;
        }
        return null;
    }

    @Override
    public String toString(){
        Node cur = dummyHead;
        StringBuilder sb = new StringBuilder();
        while(cur.next != null){
            if(cur.next.next != null){
                sb.append(cur.next.value + ", ");
            } else {
                sb.append(cur.next.value);
            }
            cur = cur.next;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Pride and prejudice");
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("src/pride-and-prejudice.txt", words)){
            System.out.println("size: "+words.size());
            LinkedListMap<String, Integer> map = new LinkedListMap<>();
            for(String word : words){
                if(map.contains(word)){
                    map.set(word, map.get(word)+1);
                } else {
                    map.add(word, 1);
                }
            }
            System.out.println("Total different words count: "+map.getSize());
            System.out.println("Frequency of word pride: "+map.get("pride"));
        }
    }
}
