package com.tianhong.leetcode.linkedListQuestions;

import java.util.HashMap;

// Given a non-empty, singly linked list with head node head, return a middle node of linked list.
// If there are two middle nodes, return the second middle node.
public class GetMiddleNode {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode middleNode(ListNode head){
        int length = 0;
        ListNode cur = head;
        ListNode mid = head;
        while(cur != null){
            length++;
            cur = cur.next;

        }
        int middleIndex = (int)Math.ceil(0.5*length+0.5) - 1;
        for(int i = 0; i < middleIndex; i++){
            mid = mid.next;
        }
        return mid;
    }

    public ListNode middleNode2(ListNode head){
        int length = 0;
        ListNode cur = head;
        HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();
        while(cur != null){
            map.put(length, cur);
            length++;
            cur = cur.next;
        }
        int middleIndex = (int)Math.ceil(length*0.5+0.5)-1;
        return map.get(middleIndex);
    }

    public static void main(String[] args) {
        GetMiddleNode test = new GetMiddleNode();
        ListNode node1 = test.new ListNode(1);
        ListNode node2 = test.new ListNode(2);
        ListNode node3 = test.new ListNode(3);
        ListNode node4 = test.new ListNode(4);
        ListNode node5 = test.new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        System.out.println(test.middleNode2(node1).val);
    }
}
