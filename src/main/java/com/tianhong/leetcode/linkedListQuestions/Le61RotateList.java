package com.tianhong.leetcode.linkedListQuestions;

// Given a linked list, rotate the list to the right by k places, where k is non-negative.
// Input: 1->2->3->4->5->NULL, k = 2
// Output: 4->5->1->2->3->NULL
// Explanation:
// rotate 1 steps to the right: 5->1->2->3->4->NULL
// rotate 2 steps to the right: 4->5->1->2->3->NULL

class ListNode7 {
    int val;
    ListNode7 next;
    ListNode7(int val){
        this.val = val;
    }
}

public class Le61RotateList {
    public ListNode7 rotateRight(ListNode7 head, int k) {
        if(head == null || head.next == null)
            return head;
        int length = 0;
        ListNode7 cur = head;
        while(cur != null){
            cur = cur.next;
            length++;
        }
        k = k % length;
        ListNode7 pre = head;
        ListNode7 start = head;
        ListNode7 end = start;
        if(k != 0) {
            for (int i = 1; i < k; i++) {
                end = end.next;
            }

            while (end.next != null) {
                pre = start;
                start = start.next;
                end = end.next;
            }

            end.next = head;
            pre.next = null;

            return start;
        } else {
            return head;
        }
    }

    public static void main(String[] args) {
        System.out.println(0%3);
    }
}
