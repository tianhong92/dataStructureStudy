package com.tianhong.leetcode.linkedListQuestions;

// Remove all elements from a linked list of integers that have value val.
// Input:  1->2->6->3->4->5->6, val = 6
// Output: 1->2->3->4->5

public class Le203RemoveListELements {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;
        ListNode reHead = new ListNode(-1);
        reHead.next = head;
        ListNode cur = head;
        while(cur.val == val && cur != null){
            cur = cur.next;
            reHead.next = cur;
        }
        ListNode pre = cur;
        while(cur != null){
            if(cur.val == val){
                cur = cur.next;
                pre .next = cur;
            } else {
                cur = cur.next;
                pre = cur;
            }
        }
        return reHead;
    }
}
