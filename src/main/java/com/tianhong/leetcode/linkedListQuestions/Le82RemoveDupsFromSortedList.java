package com.tianhong.leetcode.linkedListQuestions;

// Given a sorted linked list, delete all nodes that have duplicate numbers,
// leaving only distinct numbers from the original list.
// Input: 1->2->3->3->4->4->5
// Output: 1->2->5

// Input: 1->1->1->2->3
// Output: 2->3
class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
public class Le82RemoveDupsFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        if(head.next.next == null){
            if(head.val == head.next.val)
                return null;
            else
                return head;
        }

        ListNode reHead = new ListNode(-1);
        reHead.next = head;
        ListNode pre = head;
        ListNode cur = pre.next;

        while(cur.next != null){
            if(cur.val != pre.val && cur.val != cur.next.val){
                reHead.next = cur;
                pre = cur;
                cur = cur.next;
                break;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        while(cur.next != null){
            if()
        }

    }

    public static void main(String[] args) {
        Le82RemoveDupsFromSortedList test = new Le82RemoveDupsFromSortedList();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;
    }
}
