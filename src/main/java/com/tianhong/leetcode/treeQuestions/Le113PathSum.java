package com.tianhong.leetcode.treeQuestions;

// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
// Given the below binary tree and sum = 22,
//
//        5
//       / \
//      4   8
//     /   / \
//    11  13  4
//   /  \    / \
//  7    2  5   1
//
// return
//
// [
//     [5,4,11,2],
//     [5,8,4,5]
// ]

import java.util.ArrayList;
import java.util.List;

public class Le113PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        return getList(root, list, path, 0, sum);
    }

    public List<List<Integer>> getList(TreeNode node, List<List<Integer>> list, List<Integer> path, int total, int sum){
        if(node == null)
            return list;
        if(node.left == null && node.right == null && (total+node.val) == sum){
            path.add(node.val);
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < path.size(); j++){
                temp.add(path.get(j));
            }
            list.add(temp);
            path.remove(path.size() - 1);
            return list;
        }
        path.add(node.val);
        total += node.val;
        getList(node.left, list, path, total, sum);
        getList(node.right, list, path, total, sum);
        path.remove(path.size() - 1);
        return list;
    }
}
