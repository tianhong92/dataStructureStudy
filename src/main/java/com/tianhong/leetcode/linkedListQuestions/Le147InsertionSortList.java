package com.tianhong.leetcode.linkedListQuestions;

class ListNode5 {
    int val;
    ListNode5 next;
    ListNode5(int val){
        this.val = val;
    }
}

// 插入排序
// Input: 4->2->1->3
// Output: 1->2->3->4

public class Le147InsertionSortList {
    public ListNode5 insertionSortList(ListNode5 head) {
        if(head == null || head.next == null)
            return head;
        ListNode5 dummy = new ListNode5(-1);
        dummy.next = new ListNode5(head.val);
        ListNode5 cur = head.next;
        ListNode5 cur1;
        while(cur != null){
            cur1 = dummy;
            while(cur1.next != null){
               if(cur.val <= cur1.next.val){
                   ListNode5 temp = cur1.next;
                   cur1.next = new ListNode5(cur.val);
                   cur1.next.next = temp;
                   cur = cur.next;
                   break;
               } else {
                   cur1 = cur1.next;
               }
            }
            if(cur1.next == null){
               cur1.next = new ListNode5(cur.val);
               cur1.next.next = null;
               cur = cur.next;
            }
        }
        return dummy.next;
    }


}
