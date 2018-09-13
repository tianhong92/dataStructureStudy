package com.tianhong.DIYDataStructure.Map;

public interface Map<K, V> {
    void add(K key, V value);
    V remove(K key);
    boolean contains(K key);
    void set(K key, V value);
    int getSize();
    boolean isEmpty();
    V get(K key);
}
