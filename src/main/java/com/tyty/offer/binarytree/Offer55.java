package com.tyty.offer.binarytree;

public class Offer55 {

    int ans = 0;

    public int maxDepth(TreeNode root) {

        reverse(root, 0);
        return ans;
    }

    public void reverse(TreeNode root, int depth) {
        if (null == root) {
            return;
        }
        depth++;
        ans = Math.max(ans, depth);
        reverse(root.left, depth);
        reverse(root.right, depth);
        depth--;
    }
}
