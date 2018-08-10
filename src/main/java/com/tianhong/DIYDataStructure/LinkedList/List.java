package com.tianhong.DIYDataStructure.LinkedList;

public interface List<E> {
    int getSize();
    boolean isEmpty();
    void addFirst(E e);
    void add(int index, E e);
    void addLast(E e);
}
