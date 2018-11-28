package com.tianhong.Jianzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: TianhongWang
 * @Date: 2018/11/28
 * @Description
 */
// 输入链表的第一个节点，从尾到头反过来打印出每个结点的值。
public class Re6ReverseList {
//    public static ArrayList<Integer> reverse(ListNode head){
//        ArrayList<Integer> ret = new ArrayList<>();
//
//    }

    public static ListNode getNext(ListNode node){
        if(node == null || node.next == null){
            return node;
        }
        ListNode newHead = getNext(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }

    private static class ListNode{
        public int val;
        public ListNode next;
        public ListNode(){
            this.next = new ListNode();
        }
        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(3, null);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        //ListNode head = new ListNode(1);
        getNext(node1);
    }
}
