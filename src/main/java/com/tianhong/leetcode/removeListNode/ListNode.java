package com.tianhong.leetcode.removeListNode;

// leetcode #203 remove linked list elements
// input:  1->2->6->3->4->5->6, val = 6
// output: 1->2->3->4->5

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }


    public static ListNode removeElements1(ListNode head, int val) {
        while(head != null && head.val == val) {
            head = head.next;
        }

        if(head.next == null || head == null)
            return head;

        ListNode preHead = head;
        while(head != null && head.next != null) {
            ListNode removeNode = head.next;
            ListNode nextNode = removeNode.next;
            if(removeNode.val == val) {
                head.next = nextNode;
                removeNode.next = null;
            }
            else
                head = removeNode;
        }

        return preHead;
    }

    // 创建虚拟头结点
    public static ListNode removeElements2(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        if(head.next == null || head == null)
            return head;

        ListNode preHead = dummyNode;
        while(preHead != null && preHead.next != null) {
            ListNode removeNode = preHead.next;
            ListNode nextNode = removeNode.next;
            if(removeNode.val == val) {
                preHead.next = nextNode;
                removeNode.next = null;
            }
            else
                preHead = removeNode;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        ListNode newNode = ListNode.removeElements2(node1, 2);
        while(newNode.next != null) {
            System.out.println(newNode.val);
            newNode = newNode.next;
            if(newNode.next == null)
                System.out.println(newNode.val);
        }
    }
}







