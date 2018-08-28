package com.tianhong.leetcode.linkedListQuestions;

import java.util.Stack;

// Input: 1->2 Output: false
// Input: 1->2->2->1 Output: true
// Input: 1->1->0 Output: false
// Input: 1->0->1 Output: true
public class PalindromeLinkedList {
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
    // 快慢指针一起走， 快指针不能继续往下走的时候快指针刚好走到中点
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        Stack stack = new Stack();
        ListNode slow = head;
        ListNode quick = head;
        stack.push(slow.val);
        while(quick.next != null && quick.next.next != null){
            slow = slow.next;
            quick = quick.next.next;
            stack.push(slow.val);
        }
        if(quick.next == null){
            stack.pop();
        }
        while(slow.next != null){
            slow = slow.next;
            if((int)stack.pop() != slow.val){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList test = new PalindromeLinkedList();

        ListNode node4 = test.new ListNode(1, null);
        ListNode node3 = test.new ListNode(2, node4);
        ListNode node2 = test.new ListNode(1, node3);
        ListNode node1 = test.new ListNode(1, node2);

        System.out.println(test.isPalindrome(node1));

    }
}
