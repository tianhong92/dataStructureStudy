package com.tianhong.leetcode.treeQuestions;
import java.util.ArrayList;
import java.util.List;

// Input:
//
//      1
//     / \
//    2   3
//     \
//      5
//
//Output: ["1->2->5", "1->3"]
// Given a binary tree, return all root-to-leaf paths.
public class Le257BTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        return addPaths(root, new ArrayList<>(), new StringBuilder());
    }

    public List<String> addPaths(TreeNode node, List<String> list, StringBuilder sb){
        if(node == null)
            return list;
        int temp = sb.length();
        if(node.right == null && node.left == null){
            sb.append(node.val);
            list.add(sb.toString());
            sb.delete(temp, sb.length());
            return list;
        }
        sb.append(node.val);
        sb.append("->");

        addPaths(node.right, list, sb);
        addPaths(node.left, list, sb);
        sb.delete(temp, sb.length());
        return list;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        sb.append("b");
        sb.append("c");
        System.out.println(sb);
        sb.delete(1, 2);
        System.out.println(sb);
    }
}
