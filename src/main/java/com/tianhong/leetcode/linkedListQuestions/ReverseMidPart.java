package com.tianhong.leetcode.linkedListQuestions;

import com.tianhong.leetcode.removeListNode.ListNode;

public class ReverseMidPart {
    public ListNode reverse(ListNode head, int start, int end) {
        if(end <= start)
             return head;
        ListNode p1 = head;
        for(int i = 0; i < start - 1; i++) {
            p1 = p1.next;
        }
        ListNode pre = p1.next;
        ListNode s = pre;
        ListNode cur = pre.next;
        for(int i = 0; i < end - start; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        p1.next = pre;
        s.next = cur;
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(2);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(6);
        ListNode n9 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = null;

        ListNode cur = n1;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }

        ReverseMidPart test = new ReverseMidPart();
        ListNode ret = test.reverse(n1, 2, 5);
        System.out.println();
        while(ret != null) {
            System.out.print(ret.val + " ");
            ret = ret.next;
        }
    }
}
