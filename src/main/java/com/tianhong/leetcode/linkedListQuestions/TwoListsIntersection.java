package com.tianhong.leetcode.linkedListQuestions;

import java.util.HashMap;

// A: a1 -> a2 -> c1 -> c2 -> c3
// B: b1 -> b2 -> b3 -> c1 -> c2 -> c3
// return c1
public class TwoListsIntersection {
    private class ListNode {
        private int val;
        private ListNode next;
        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
        public ListNode(int val){
            this.val = val;
        }
    }

    // 利用hashmap存储headA的节点信息。
    // Time Complexity: O(m+n)
    // Space Complexity: O(m)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        HashMap<ListNode, Integer> map = new HashMap();
        ListNode cur1 = headA;
        ListNode cur2 = headB;

        while(cur1 != null){
            map.put(cur1, 1);
            cur1 = cur1.next;
        }
        while(cur2 != null){
            if(map.containsKey(cur2)){
                return cur2;
            }
            cur2 = cur2.next;
        }
        return null;
    }

    // 利用两个指针分别指向链表头， 遍历完当前链表接着遍历下一个链表。
    // Time Complexity O(M+N)
    // Space Complexity O(0)
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB){
        if(headA == null || headB == null){
            return null;
        }
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        if(headA == headB){
            return headA;
        }
        boolean cur1HasLinkedToCur2 = false;
        boolean cur2HasLinkedToCur1 = false;
        while(cur1 != null && cur2 != null && cur1 != cur2){
            if(cur1.next == null && !cur1HasLinkedToCur2){
                cur1 = headB;
                cur1HasLinkedToCur2 = true;
            } else {
                cur1 = cur1.next;
            }

            if(cur2.next == null && !cur2HasLinkedToCur1){
                cur2 = headA;
                cur2HasLinkedToCur1 = true;
            } else {
                cur2 = cur2.next;
            }
        }
        return cur1;
    }

    public static void main(String[] args) {
        TwoListsIntersection test = new TwoListsIntersection();
        ListNode c3 = test.new ListNode(2, null);
        ListNode c2 = test.new ListNode(6, c3);
        ListNode c1 = test.new ListNode(3, c2);
        ListNode a2 = test.new ListNode(2, c1);
        ListNode a1 = test.new ListNode(1, a2);

        ListNode b3 = test.new ListNode(4, c1);
        ListNode b2 = test.new ListNode(4, b3);
        ListNode b1 = test.new ListNode(4, b2);

        ListNode cur1 = a1;
        ListNode cur2 = b1;

//        while(cur1 != null){
//            System.out.print(cur1.val + " ");
//            cur1 = cur1.next;
//        }
//        System.out.println();
//        while(cur2 != null){
//            System.out.print(cur2.val + " ");
//            cur2 = cur2.next;
//        }

        ListNode ret = test.getIntersectionNode2(cur1, cur2);
        System.out.println("ret: "+ret.val);
    }
}
