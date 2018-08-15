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

    // 获得链表的第index（0-based）个位置的元素
    // 在链表中不是常用的操作， 练习用
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed, Illegal index.");
        }
        Node cur = head.next;
        for(int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    // 获取链表第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获取链表最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    // 修改链表第index（0-based)个位置的元素为e
    // 在链表中不是一个常用的操作， 练习用
    public void set(int index, E e){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed, Illegal index.");
        }
        Node cur = head.next;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    // 查找链表中是否存在元素e
    public boolean contains(E e){
        Node cur = head.next;
        for(int i = 0; i < size - 1; i++){
            cur = cur.next;
            if(cur.e.equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 从链表中删除第index（0-based）个元素, 并返回这个元素
    // 不是链表中常用操作， 练习用
    public E remove(int index){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed, illegal index.");
        }
        Node prev = head;
        for(int i = 0; i < index; i++){
            prev = prev.next;
        }
        Node cur = prev.next;
        prev.next = cur.next;
        cur.next = null;
        size--;
        return cur.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
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
        list.set(1, 4);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
    }
}
