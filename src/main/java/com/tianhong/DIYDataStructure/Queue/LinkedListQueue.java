package com.tianhong.DIYDataStructure.Queue;

// 增加一个尾指针提高队列的效率
// 队列头删除元素， 队列尾增加元素
public class LinkedListQueue<E> implements Queue<E> {
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(){
            this(null, null);
        }

        public Node(E e){
            this(e, null);
        }

        public String toString(){
            return e.toString();
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int getSize() {
         return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if(size == 0){
            head = new Node(e);
            head.next = null;
            size++;
        } else if(size == 1){
            tail = new Node(e);
            head.next = tail;
            tail.next = null;
            size++;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
            tail.next = null;
            size++;
        }
    }

    @Override
    public E dequeue() {
        if(size <= 0) {
            throw new IllegalArgumentException("Dequeue Failed");
        }
        Node ret = head;
        head = head.next;
        size--;
        return ret.e;
    }

    @Override
    public E getFront() {
        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();
        ret.append("front [");
        Node cur = head;
        for(int i = 0; i < size; i++){
            ret.append(cur.e);
            cur = cur.next;
            if(i != (size - 1)){
                ret.append(", ");
            }
        }
        ret.append("] end");
        return ret.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue();
        for(int i = 0; i < 5; i++){
            queue.enqueue(i);
        }
        System.out.println(queue);
        for(int i = 0; i < 5; i++){
            queue.dequeue();
            System.out.println(queue);
        }
    }
}
