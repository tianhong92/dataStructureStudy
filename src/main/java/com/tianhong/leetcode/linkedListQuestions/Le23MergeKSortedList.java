package com.tianhong.leetcode.linkedListQuestions;

import com.tianhong.leetcode.removeListNode.ListNode;

public class Le23MergeKSortedList {
    // 归并排序
    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);
    }

    public ListNode partition(ListNode[] lists, int left, int right) {
        if(left == right) {
            return lists[left];
        }
        if(left < right) {
            int mid = (left + right)/2;
            ListNode l1 = partition(lists, left, mid);
            ListNode l2 = partition(lists, mid + 1, right);
            return mergeLists(l1, l2);
        } else {
            return null;
        }
    }

    public ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l1 != null || l2 != null) {
            if(l1 == null) {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l2 == null) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else if (l1.val <= l2.val){
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;

        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n4.next = n5;
        n5.next = n6;
        Le23MergeKSortedList test = new Le23MergeKSortedList();

        ListNode cur = test.mergeLists(n1, n4);
        System.out.println("24232323");
    }
}
