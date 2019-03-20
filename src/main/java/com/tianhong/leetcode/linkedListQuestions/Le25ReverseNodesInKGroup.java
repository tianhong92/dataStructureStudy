package com.tianhong.leetcode.linkedListQuestions;

// k is a positive integer and is less than or equal to the length of the linked list.
// If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
class ListNode4 {
    int val;
    ListNode4 next;
    ListNode4(int val){
        this.val = val;
    }
}

public class Le25ReverseNodesInKGroup {

//    public ListNode4 reverseKGroup(ListNode4 head, int k) {
//        if(head == null || head.next == null)
//            return head;
//        ListNode4 dummy = new ListNode4(-1);
//        ListNode4 pre = dummy;
//        ListNode4 cur = head;
//
//        for(int i = 0; i < k - 1; i++){
//            ListNode4 mid = cur.next;
//
//        }
//    }

    // 反转（begin， end）区间（不包含）内的节点， 并返回
    // 0 -> 2 -> 3 -> 4 -> 5 -> 6   (0, 5)
    // 0 -> 4 -> 3 -> 2 -> 5 -> 6   @return 2
    public ListNode4 reverse(ListNode4 begin, ListNode4 end){
        ListNode4 pre = begin.next;
        ListNode4 cur = pre.next;
        ListNode4 first = begin.next;

        while(cur != end){
            ListNode4 next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        begin.next = pre;
        first.next = cur;
        return first;
    }
}
