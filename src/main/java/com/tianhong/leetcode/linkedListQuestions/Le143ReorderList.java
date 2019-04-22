package com.tianhong.leetcode.linkedListQuestions;

// Given a singly linked list L: L0→L1→…→Ln-1→Ln,
// reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
// You may not modify the values in the list's nodes, only nodes itself may be changed.

// Given 1->2->3->4, reorder it to 1->4->2->3.
class ListNode9 {
    int val;
    ListNode9 next;
    ListNode9(int val){
        this.val = val;
    }
}

public class Le143ReorderList {

    public void reorderList(ListNode9 head) {
        if(head == null || head.next == null)
            return;
        // find the mid node
        ListNode9 slow = head, pre = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            pre = slow.next;
            fast = fast.next.next;
        }
        slow.next = null;
        ListNode9 second = reverse(pre);

        merge(head, second);
    }

    public ListNode9 reverse(ListNode9 head){
        if(head == null || head.next == null)
            return head;
        ListNode9 cur = head;
        ListNode9 ret = null;
        if(cur.next != null){
            ret = reverse(cur.next);
        }
        cur.next.next = cur;
        cur.next = null;
        return ret;
    }

    public ListNode9 merge(ListNode9 first, ListNode9 second){
        ListNode9 dummy = new ListNode9(-1);
        ListNode9 cur = dummy;
        dummy.next = cur;
        while(first != null && second != null){
            cur.next = first;
            cur.next = second;
            first = first.next;
            second = second.next;
        }
        if(first != null)
            cur.next = first;
        if(second != null)
            cur.next = second;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode9 node1 = new ListNode9(1);
        ListNode9 node2 = new ListNode9(2);
        ListNode9 node3 = new ListNode9(3);
        ListNode9 node4 = new ListNode9(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        Le143ReorderList test = new Le143ReorderList();
        test.reorderList(node1);
    }
}
