package com.example.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class LC112 {

    List<Integer> ans = new ArrayList<>();

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        traverse(root, 0);
        return ans.contains(targetSum);
    }

    public void traverse(TreeNode root, int sum) {
        if (root == null) {
            ans.add(sum);
            return;
        }
        sum = sum + root.val;
        //判断是否叶子结点
        //不是叶子
        if (root.left != null || root.right != null) {
            if (root.left != null) {
                traverse(root.left, sum);
            }
            if (root.right != null) {
                traverse(root.right, sum);
            }
        } else {
            traverse(root.left, sum);
            traverse(root.right, sum);
        }


    }

}
