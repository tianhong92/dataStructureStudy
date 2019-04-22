package com.tianhong.leetcode.treeQuestions;

//     Input: [4,9,0,5,1]
//           4
//          / \
//         9   0
//        / \
//       5   1
//  Output: 1026
//Explanation:
//  The root-to-leaf path 4->9->5 represents the number 495.
//  The root-to-leaf path 4->9->1 represents the number 491.
//  The root-to-leaf path 4->0 represents the number 40.
//  Therefore, sum = 495 + 491 + 40 = 1026.

import java.util.ArrayList;
import java.util.List;

public class Le129SumRootToLeaveNum {
    public int sumNumbers(TreeNode root) {
        List<Integer> paths = getList(root, new ArrayList<>(), 0);
        int total = 0;
        for(int i = 0; i < paths.size(); i++){
            total += paths.get(i);
        }
        return total;
    }

    public List<Integer> getList(TreeNode root, List<Integer> list, int path){
        if(root == null)
            return list;
        if(root.left == null && root.right == null){
            path = path * 10 + root.val;
            list.add(path);
            path = path / 10;
            return list;
        }

        path = path * 10 + root.val;
        getList(root.left, list, path);
        getList(root.right, list, path);
        path = path / 10;
        return list;
    }
}
