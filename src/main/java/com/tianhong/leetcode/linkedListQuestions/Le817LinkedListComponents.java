package com.tianhong.leetcode.linkedListQuestions;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Le817LinkedListComponents {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public int numComponents(ListNode head, int[] G) {
        if(head == null || G.length == 0)
            return 0;
        int count = 0;
        boolean start = false;
        Set<Integer> list = new HashSet<>();
        for(int i : G) {
            list.add(i);
        }
        ListNode cur = head;
        while(cur != null) {
            if(list.contains(cur.val)) {
                if(!start) {
                    count++;
                    start = true;
                }
            } else {
                start = false;
            }
            cur = cur.next;
        }
        return count;
    }
}
