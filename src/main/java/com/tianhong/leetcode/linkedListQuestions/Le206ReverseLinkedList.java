package com.tianhong.leetcode.linkedListQuestions;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
// Input: 1->2->3->4->5->NULL
// Output: 5->4->3->2->1->NULL
public class Le206ReverseLinkedList {
    // Iteratively
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode pre = head;
        ListNode cur = pre.next;
        pre.next = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return pre;
    }

    // recursively
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null)
            return head;
        if(head.next == null){
            return head;
        }
        ListNode reHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return reHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        Le206ReverseLinkedList test = new Le206ReverseLinkedList();
        ListNode ret = test.reverseList(node1);
        while(ret != null){
            System.out.print(ret.val + " ");
            ret = ret.next;
        }
    }
}
