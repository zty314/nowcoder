package com.tyty.leetcode.binarytree;

public class LC543 {

    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return ans;
    }

    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        int depth = leftDepth + rightDepth;
        ans = Math.max(ans, depth);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
