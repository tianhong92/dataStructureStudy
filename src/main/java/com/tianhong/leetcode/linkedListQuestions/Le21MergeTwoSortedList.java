package com.tianhong.leetcode.linkedListQuestions;



// Merge two sorted linked lists and return it as a new list.
// The new list should be made by splicing together the nodes of the first two lists.
// Input: 1->2->4, 1->3->4
// Output: 1->1->2->3->4->4
class LNode1 {
    int val;
    LNode1 next;
    public LNode1(int val){
        this.val = val;
    }
}

public class Le21MergeTwoSortedList {
    public LNode1 mergeTwoLists(LNode1 l1, LNode1 l2) {
        LNode1 dummy = new LNode1(-1);
        LNode1 head = dummy;
        while(l1 != null || l2 != null){
            if(l1 == null){
                head.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                head.next = l1;
                l1 = l1.next;
            } else {
                if(l1.val < l2.val){
                    head.next = l1;
                    l1 = l1.next;
                } else {
                    head.next = l2;
                    l2 = l2.next;
                }
            }
            head = head.next;
        }
        return dummy.next;
    }

}
