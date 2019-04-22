package com.tianhong.leetcode.linkedListQuestions;

// Given a sorted linked list, delete all nodes that have duplicate numbers,
// leaving only distinct numbers from the original list.
// Input: 1->2->3->3->4->4->5
// Output: 1->2->5

// Input: 1->1->1->2->3
// Output: 2->3
class LNode {
    int val;
    LNode next;
    public LNode(int val){
        this.val = val;
    }
}

public class Le82RemoveDupsFromSortedList {
    public LNode deleteDuplicates(LNode head) {
        if(head == null)
            return head;
        LNode fakeHead = new LNode(-1);
        fakeHead.next = head;
        LNode pre = fakeHead;
        LNode cur = head;
        while(cur != null) {
            while(cur.next != null && cur.next.val == cur.val){
                cur = cur.next;
            }
            if(pre.next != cur){
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return fakeHead.next;
    }

}