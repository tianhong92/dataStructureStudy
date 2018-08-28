package com.tianhong.leetcode.linkedListQuestions;

// Given a linked list, determine if it has a cycle in it.
// Follow up:
// Can you solve it without using extra space?
public class LinkedListCycle {
    private class ListNode {
        private int val;
        private ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    // 通过快慢两指针方式
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode quick = head;
        while(quick != null && quick.next != null){
            slow = slow.next;
            quick = quick.next.next;
            if(slow == quick){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle test = new LinkedListCycle();
        ListNode node5 = test.new ListNode(5);
        ListNode node4 = test.new ListNode(4, node5);
        ListNode node3 = test.new ListNode(3, node4);
        ListNode node2 = test.new ListNode(2, node3);
        ListNode node1 = test.new ListNode(1, node2);
        node5.next = node1;
        boolean ret = test.hasCycle(node1);
        System.out.println(ret);
    }
}
