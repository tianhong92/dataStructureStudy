package com.tianhong.leetcode.treeQuestions;

//      Input:
//
//           1
//          / \
//         2   3
//        / \  /
//       4  5 6
//
//      Output: 6

public class Le222CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null)
            return 1;
        int rightH = 0;
        int leftH = 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        while(left != null){
            leftH++;
            left = left.left;
        }
        while(right != null){
            rightH++;
            right = right.right;
        }
        if(rightH == leftH){
            return 2 * (1 << leftH) - 1;        // ((1 << leftH) - 1) * 2 + 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static void main(String[] args) {
        System.out.println(1 << 0);
    }

}
