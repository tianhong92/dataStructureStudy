package com.tianhong.leetcode.linkedListQuestions;

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
}
