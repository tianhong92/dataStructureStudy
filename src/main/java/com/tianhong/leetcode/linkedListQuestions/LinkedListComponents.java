package com.tianhong.leetcode.linkedListQuestions;

// Input: head: 0->1->2->3->4
// G = [0, 3, 1, 4]
// Output: 2
// 0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
public class LinkedListComponents {
    private class ListNode {
        private int val;
        private ListNode next;
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    // 首先遍历原List得到所有connected对存入
//    public int numComponents(ListNode head, int[] G) {
//
//    }

    public static void main(String[] args) {

    }
}
