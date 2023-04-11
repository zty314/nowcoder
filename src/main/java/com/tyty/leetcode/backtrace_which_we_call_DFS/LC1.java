package com.tyty.leetcode.backtrace_which_we_call_DFS;

import java.util.LinkedList;

public class LC1 {

    int[] ans = new int[2];
    LinkedList<Integer> path = new LinkedList<>();
    LinkedList<Integer> indexPath = new LinkedList<>();

    public int[] twoSum(int[] nums, int target) {
        backTrace(0,nums,target);
        return ans;
    }

    public void backTrace(int start, int[] nums, int target) {
        if (path.size() == 2) {
            if (path.get(0) + path.get(1) == target) {
                for (int i = 0; i < path.size(); i++) {
                    ans[i] = indexPath.get(i);
                }
            }
            return;
        }

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            indexPath.add(i);
            backTrace(i + 1, nums, target);
            path.removeLast();
            indexPath.removeLast();
        }
    }
}
