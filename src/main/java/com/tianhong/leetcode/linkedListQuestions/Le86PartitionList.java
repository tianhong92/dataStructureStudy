package com.tianhong.leetcode.linkedListQuestions;
import com.tianhong.leetcode.removeListNode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Le86PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)
            return head;
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            if(list.isEmpty()){
                list.add(head.val);
            }
            if(head.val < x) {
                for(int i = 0; i < list.size(); i++) {
                    if(head.val <= list.get(i)) {
                        list.add(i, head.val);
                        break;
                    }
                    if(i == list.size() - 1){
                        list.add(list.get(i));
                    }
                }
            } else {
                list.add(head.val);
            }
            head = head.next;
        }
        ListNode newHead = new ListNode(list.get(0));
        for(int i = 1; i < list.size(); i++){
            newHead.next = new ListNode(list.get(i));
        }
        return newHead;
    }
}
