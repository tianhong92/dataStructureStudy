package com.tianhong.leetcode.treeQuestions;

// You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
// Input: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
// Output: 1

// Input: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
// Output: 3

import java.util.ArrayList;
import java.util.List;

public class Le230KthSmallestNodeInBST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ret = traverse(root, new ArrayList<>(), k);
        return ret.get(k - 1);
    }

    public List<Integer> traverse(TreeNode root, List<Integer> list, int k){
        if(root == null)
            return list;
        if(root.left == null && root.right == null) {
            list.add(root.val);
            return list;
        }
        traverse(root.left, list, k);
        list.add(root.val);
        if(list.size() == k)
            return list;
        traverse(root.right, list, k);
        return list;
    }
}
