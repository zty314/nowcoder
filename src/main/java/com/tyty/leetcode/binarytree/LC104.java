package com.tyty.leetcode.binarytree;

public class LC104 {

    int depth = 0;
    int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        traverse(root, 0);
        return maxDepth;
    }

    public void traverse(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        depth++;
        maxDepth = Math.max(maxDepth, depth);
        traverse(root.left, depth);
        traverse(root.right, depth);
        depth--;
    }
}
