package com.tianhong;

public class ReverseList {

    // recursive way
    public static Node reverse(Node head) {
        if(head == null || head.getNext() == null) {
            return head;
        }

        Node reHead = reverse(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return reHead;
    }

    public static Node reverse2(Node head) {
       if(head == null || head.getNext() == null) {
           return head;
       }
       Node current = head.getNext();
       Node next = current.getNext();

       if(next == null) {
           current.setNext(head);
           head.setNext(null);
           return current;
       }
       head.setNext(null);
       while(next != null) {
           Node temp = next.getNext();
           next.setNext(current);
           current.setNext(head);
           head = current;
           current = next;
           next = temp;
       }

       return current;
    }

    public static void main(String[] args) {

        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);



        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(null);


        Node current = reverse2(head);
        while(current != null) {
            System.out.println("data: "+current.getData());
            current = current.getNext();
        }
    }
}


class Node {
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public int getData() {
        return data;
    }
}