//package com.tianhong.leetcode.linkedListQuestions;
//
//// Remove all elements from a linked list of integers that have value val.
//// Input:  1->2->6->3->4->5->6, val = 6
//// Output: 1->2->3->4->5
//
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x){
//        val = x;
//    }
//}
//
//public class Le203RemoveListELements {
//
//    public ListNode removeElements(ListNode head, int val) {
//        if(head == null)
//            return head;
//        ListNode newHead = new ListNode(-1);
//        newHead.next = head;
//        while(newHead.next != null){
//            if(newHead.next.val == val){
//                newHead.next = newHead.next.next;
//            } else {
//                break;
//            }
//        }
//        ListNode pre = newHead;
//        while(pre.next != null){
//            if(pre.next.val == val){
//                pre.next = pre.next.next;
//            } else {
//                pre = pre.next;
//            }
//        }
//        return newHead.next;
//    }
//
//    public static void main(String[] args) {
//        Le203RemoveListELements test = new Le203RemoveListELements();
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(6);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(6);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = null;
//        ListNode ret = test.removeElements(node1, 6);
//        System.out.println(ret);
//
//    }
//}
