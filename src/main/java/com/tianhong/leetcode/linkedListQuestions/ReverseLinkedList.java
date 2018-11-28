package com.tianhong.leetcode.linkedListQuestions;

// Input: 1->2->3->4->5->NULL
// Output: 5->4->3->2->1->NULL
public class ReverseLinkedList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x){ val = x; }
    }

    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        pre.next = null;

        while(cur != null){
            ListNode next = cur.next;
            cur.next = head;
            head = cur;
            cur = next;
        }
        return head;
    }

    public ListNode reverseList2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList2(head.next);

        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ReverseLinkedList test = new ReverseLinkedList();
        ReverseLinkedList.ListNode node1 = test.new ListNode(1);
        ReverseLinkedList.ListNode node2 = test.new ListNode(2);
        ReverseLinkedList.ListNode node3 = test.new ListNode(3);
        ReverseLinkedList.ListNode node4 = test.new ListNode(4);
        ReverseLinkedList.ListNode node5 = test.new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ListNode newNode = test.reverseList2(node1);

        ListNode cur = newNode;
        while(cur != null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
    }
}
