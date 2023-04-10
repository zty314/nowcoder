package com.tyty.leetcode.bfs;

import java.util.LinkedList;

public class LC111 {

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int depth = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode poll = queue.poll();
                if(poll.left == null && poll.right == null){
                    return depth;
                }
                if(poll.left != null){
                    queue.add(poll.left);
                }
                if(poll.right != null){
                    queue.add(poll.right);
                }
            }

            depth++;
        }
        return depth;
    }
}
