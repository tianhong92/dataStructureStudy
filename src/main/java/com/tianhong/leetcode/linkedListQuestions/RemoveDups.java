package com.tianhong.leetcode.linkedListQuestions;

import java.util.HashSet;

// Input: 1->1->2->3->3
// Output: 1->2->3
public class RemoveDups {
    private class ListNode {
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
        public ListNode(int val, ListNode node){
            this.val = val;
            this.next = node;
        }
    }

    // 使用hashset记录不重复的node， 效率比较低
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        HashSet<Integer> hSet = new HashSet<>();
        hSet.add(head.val);
        ListNode cur = new ListNode(head.val);
        ListNode newHead = cur;

        while(head.next != null){
            if(!hSet.contains(head.next.val)){
                cur.next = new ListNode(head.next.val);
                cur = cur.next;
                hSet.add(head.next.val);
            }
            head = head.next;
        }
        return newHead;
    }

    // 利用以前以后两个指针的方式， 如果两个指针指向的节点值相等，
    // 则移动后一个指针直到值不一样。 然后前一个指针指向后一个指针。
    public ListNode deleteDuplicates2(ListNode head){
        if(head == null || head.next == null)
            return head;

        ListNode prev = head;
        ListNode p = head.next;

        while(p != null){
            if(p.val == prev.val){
                prev.next = p.next;
                p = p.next;
                //no change prev
            }else{
                prev = p;
                p = p.next;
            }
        }

        return head;
    }


    public static void main(String[] args) {
        RemoveDups test = new RemoveDups();
        ListNode node5 = test.new ListNode(2, null);
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
