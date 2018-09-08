package com.tianhong.DIYDataStructure.Set;

import com.tianhong.DIYDataStructure.LinkedList.DummyHeadLinkedList;

public class LinkedListSet<E> implements Set<E> {
    DummyHeadLinkedList<E> list = new DummyHeadLinkedList<>();


    @Override
    public void add(E e) {
        if(!list.contains(e))
            list.addFirst(e);
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
