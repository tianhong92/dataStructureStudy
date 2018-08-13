package com.tianhong.DIYDataStructure.LinkedList;

public class DummyHeadLinkedList<E> implements List<E> {
    private class Node {
        private E e;
        private Node next;
        public Node(E e) {
            this.e = e;
        }
        public Node() {

        }
    }

    private int size;
    private Node head;

    public DummyHeadLinkedList() {
        this.head = new Node(null);
        this.size = 0;
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
    public void addFirst(E e) {
        add(0, e);
    }

    @Override
    public void add(int index, E e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Illegal index");
        }
        Node prev = head;
        for(int i = 0; i < index; i++){
            prev = prev.next;
        }
        Node next = prev.next;
        Node node = new Node(e);
        prev.next = node;
        node.next = next;
        size++;
    }

    @Override
    public void addLast(E e) {
        add(size, e);
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("start [");
        Node i = head.next;
        for(int j = 0; j < size; j++){
            str.append(i.e.toString());
            if(j != size - 1){
                str.append(", ");
            }
            i = i.next;
        }
        str.append("] end");
        return str.toString();
    }

    public static void main(String[] args) {
        DummyHeadLinkedList<Integer> list = new DummyHeadLinkedList<>();
        for(int i = 0; i < 3; i++){
            System.out.println(i);
            list.add(i, i);
        }
        System.out.println(list);
    }
}
