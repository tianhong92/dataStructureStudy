package com.tianhong.leetcode.linkedListQuestions;

import java.util.HashSet;

// Input: 1->1->2->3->3
// Output: 1->2->3
public class RemoveDups {
    private class ListNode {
        int val;
        ListNode next;
        public ListNode(int val, ListNode node){
            this.val = val;
            this.next = node;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        HashSet<Integer> hSet = new HashSet<>();
        hSet.add(head.val);
        ListNode newHead = new ListNode(head.val, null);
        ListNode cur = newHead;
        while(head.next != null){
            if(!hSet.contains(head.next.val)){
                newHead.next = new ListNode(head.next.val, null);
                newHead = newHead.next;
                hSet.add(head.next.val);
            }
            head = head.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        RemoveDups test = new RemoveDups();
        ListNode node5 = test.new ListNode(5, null);
        ListNode node4 = test.new ListNode(6, node5);
        ListNode node3 = test.new ListNode(2, node4);
        ListNode node2 = test.new ListNode(2, node3);
        ListNode node1 = test.new ListNode(1, node2);
        ListNode ret = test.deleteDuplicates(node1);

        ListNode cur = ret;
        while(cur != null){
            System.out.println(cur.val + " ");
            cur = cur.next;
        }
    }

}
