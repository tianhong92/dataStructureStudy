package com.tianhong.leetcode.linkedListQuestions;

// 归并排序
// Sort a linked list in O(n log n) time using constant space complexity.
// Input: 4->2->1->3
// Output: 1->2->3->4

class ListNode6 {
    int val;
    ListNode6 next;
    ListNode6(int val){
        this.val = val;
    }
}

public class Le148SortList {
    public ListNode6 sortList(ListNode6 head) {
        if(head == null || head.next == null)
            return head;
        ListNode6 pre = head, slow = head, fast = head;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        ListNode6 l = sortList(head);
        ListNode6 r = sortList(slow);
        return merge(l, r);
    }

    public ListNode6 merge(ListNode6 l1, ListNode6 l2){
        ListNode6 dummy = new ListNode6(-1);
        ListNode6 ret = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                ret.next = l1;
                l1 = l1.next;
            } else {
                ret.next = l2;
                l2 = l2.next;
            }
            ret = ret.next;
        }
        if(l1 != null){
            ret.next = l1;
        }
        if(l2 != null){
            ret.next = l2;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode6 node1 = new ListNode6(1);
        ListNode6 node2 = new ListNode6(2);
        ListNode6 node3 = new ListNode6(3);

        node1 = node2;
        node1.next = node3;

        System.out.println(node1.next.val);
        System.out.println(node2.next.val);
    }
}
