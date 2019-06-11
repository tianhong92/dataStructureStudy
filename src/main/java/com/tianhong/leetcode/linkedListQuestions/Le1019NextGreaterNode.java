package com.tianhong.leetcode.linkedListQuestions;

import com.tianhong.leetcode.removeListNode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Le1019NextGreaterNode {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        int max = -1;
        while(head.next != null) {
            ListNode cur = head;
            if(max > 0 && cur.val == max){
                list.add(0);
                head = head.next;
                continue;
            }
            ListNode iter = cur.next;
            while(iter != null) {
                if(iter.val > cur.val){
                    list.add(iter.val);
                    break;
                }
                iter = iter.next;
                if(iter == null){
                    max = cur.val;
                    list.add(0);
                }
            }
            head = head.next;
        }
        list.add(0);
        int[] ret = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
