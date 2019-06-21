package com.tianhong.leetcode.linkedListQuestions;

import com.tianhong.leetcode.removeListNode.ListNode;

public class Le2AddTwoNums {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int power = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = new ListNode((l1.val + l2.val) % 10);
        power = ( l1.val + l2.val ) / 10;
        dummy.next = cur;
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null || l2 != null) {
            int curVal = 0;
            if(l1 == null) {
                curVal = l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                curVal = l1.val;
                l1 = l1.next;
            } else {
                curVal = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            cur.next = new ListNode((curVal + power) % 10);
            cur = cur.next;
            power = ( curVal + power ) / 10;
        }
        if(power != 0) {
            cur.next = new ListNode(power);
        }
        return dummy.next;
    }
}
