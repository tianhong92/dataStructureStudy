package com.tianhong.leetcode.linkedListQuestions;

import com.tianhong.leetcode.removeListNode.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Le19RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return head;
        }
        ListNode c = head;
        int length = 0;
        while(c != null) {
            c = c.next;
            length++;
        }
        int loc = length - n;
        if(loc == 0) {
            return head.next;
        }
        ListNode cur = head;
        for(int i = 0; i < loc - 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }
}
