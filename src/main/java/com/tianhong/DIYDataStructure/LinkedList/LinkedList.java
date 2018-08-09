package com.tianhong.DIYDataStructure.LinkedList;

public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
        public Node(E e) {
            this(e, null);
        }
        public Node() {
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    //获取链表中元素个数
    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        head = new Node(e, head);
        size++;
    }

    // 在链表index（0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作， 练习用， 一般不用索引
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Illegal index");
        }
        if(size == 0) {
            head = new Node(e);
            size++;
            return;
        }
        Node node = new Node(e);
        Node preNode = null;
        Node nextNode = null;
        for(int i = 0; i < index; i++) {
            preNode = head;
            nextNode = head.next;
            head = nextNode;
        }
        preNode.next = node;
        node.next = nextNode;
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i < 5; i++){
            linkedList.add(i, i);
        }
        System.out.println(linkedList);
    }

}
