package com.tianhong.leetcode.linkedListQuestions;

import java.util.*;

// Input: 1->2->4, 1->3->4
// Output: 1->1->2->3->4->4
public class MergeTwoSortedList {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode head = ret;
        while(l1 != null || l2 != null) {
            if(l1 == null){
                ret.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                ret.next = l1;
                l1 = l1.next;
            } else { // cur1 != null && cur2 != null
                if(l1.val <= l2.val){
                    ret.next = l1;
                    l1 = l1.next;
                } else {
                    ret.next = l2;
                    l2 = l2.next;
                }
            }
            ret = ret.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedList test = new MergeTwoSortedList();
        ListNode node6 = test.new ListNode(4, null);
        ListNode node5 = test.new ListNode(3, node6);
        ListNode node4 = test.new ListNode(1, node5);

        ListNode node3 = test.new ListNode(4, null);
        ListNode node2 = test.new ListNode(2, node3);
        ListNode node1 = test.new ListNode(1, node2);

        ListNode newNode = test.mergeTwoLists(node1, node4);
        ListNode newCur = newNode;
        while(newCur != null){
            System.out.println(newCur.val+" ");
            newCur = newCur.next;
        }
    }

}
