package com.tianhong.leetcode.removeListNode;

// leetcode #203 remove linked list elements
// input:  1->2->6->3->4->5->6, val = 6
// output: 1->2->3->4->5


import org.w3c.dom.NodeList;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x){
        val = x;
    }
    ListNode(int x, ListNode next){
        val = x;
        this.next = next;
    }

    public static ListNode removeNode(ListNode head, int target){
        while(head != null && head.val == target){
            ListNode temp = head;
            head = head.next;
            temp = null;
        }
        if(head == null){
            return null;
        }
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val == target){
                cur = cur.next;
                prev.next = cur;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    // remove nodes in a recursive way
    public static ListNode removeNode2(ListNode head, int target){
        if(head == null) {
            return null;
        }
        head.next = removeNode2(head.next, target);
        return head.val == target ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode node7 = new ListNode(3, null);
        ListNode node6 = new ListNode(3, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(3, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode head1 = node1;
        while (head1 != null){
            System.out.print(head1.val+" ");
            head1 = head1.next;
        }
        System.out.println("end");
        ListNode head2 = node1;
        ListNode newNode = removeNode2(head2, 3);
        while(newNode != null){
            System.out.print(newNode.val+" ");
            newNode = newNode.next;
        }
    }
}





