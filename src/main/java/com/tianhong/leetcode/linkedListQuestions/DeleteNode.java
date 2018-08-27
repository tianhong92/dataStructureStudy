package com.tianhong.leetcode.linkedListQuestions;

// Input: head = [4,5,1,9], node = 1
// Output: [4,5,9]

public class DeleteNode {

    private class ListNode {
        //friendly作用域， 当前类和同一个package
        int val;
        private ListNode next;
        ListNode(int val){
            this.val = val;
            next = null;
        }
    }

    // 拷贝当前节点下一个节点为当前节点。 然后删除后一个节点
    public void deleteNode(ListNode node){
        if(node == null || node.next == null){
            node = null;
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        DeleteNode test = new DeleteNode();
        ListNode node1 = test.new ListNode(1);
        ListNode node2 = test.new ListNode(2);
        ListNode node3 = test.new ListNode(3);
        ListNode node4 = test.new ListNode(4);
        ListNode node5 = test.new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        test.deleteNode(node4);
        test.deleteNode(node1);

        ListNode cur = node1;
        while(cur != null){
            System.out.println(cur.val + " ");
            cur = cur.next;
        }

    }

}
