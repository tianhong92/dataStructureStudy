package com.tianhong.leetcode.linkedListQuestions;

import com.tianhong.leetcode.removeListNode.ListNode;

class ListNode3 {
    int val;
    ListNode3 next;
    ListNode3(int val){
        this.val = val;
    }
}
public class Le24SwapNodesInPairs {

    public ListNode3 swapPairs(ListNode3 head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode3 pre = head;
        ListNode3 cur = pre.next;
        ListNode3 next;
        ListNode3 dummy = new ListNode3(-1);
        dummy.next = cur;
        while(pre != null && cur != null){
            next = cur.next;
            cur.next = pre;
            if(next != null && next.next != null)
                pre.next = next.next;
            else
                pre.next = next;

            pre = next;
            if(pre != null)
                cur = pre.next;
            else
                cur = null;

        }

        return dummy.next;
    }


    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next;
        dummy.next = cur;
        while(pre != null && cur != null) {
            next = cur.next;
            cur.next = pre;
            if(next != null && next.next != null) {
                pre.next = next.next;
            } else {
                pre.next = next;
            }
            pre = next;
            if(pre == null) {
                cur = null;
            } else {
                cur = pre.next;
            }
        }
        return dummy.next;
    }
}
