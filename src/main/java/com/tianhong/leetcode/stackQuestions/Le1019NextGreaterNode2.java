package com.tianhong.leetcode.stackQuestions;

import com.tianhong.leetcode.removeListNode.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Le1019NextGreaterNode2 {
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] ret = new int[list.size()];
        for(int i = 0 ; i < list.size(); i++) {
            while(!stack.empty() && list.get(i) > list.get(stack.peek())){
                ret[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        return ret;
    }
}
