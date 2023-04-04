package com.example.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversalOfBinaryTrees {

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> integers = new ArrayList<>();
        inorder(root, integers);
        return integers;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if(root == null){
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }


}
