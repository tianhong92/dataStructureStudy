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
        ListNode cur = head;
        while(cur.next != null){
            if(cur.val == cur.next.val){
                cur = cur.next;
            } else {
                break;
            }
        }
        ListNode reHead = cur.next;
        ListNode pre = reHead;
        cur = cur.next.next;
        if(cur == null)
            return reHead;
        while(cur.next != null){
            if(cur.val == cur.next.val){
                cur = cur.next;
            } else {
                cur = cur.next;
                pre.next = cur;
                pre = cur;
            }
        }
        return reHead;

    }
}
