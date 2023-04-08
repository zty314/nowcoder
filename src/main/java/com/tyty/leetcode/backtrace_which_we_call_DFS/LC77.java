package com.tyty.leetcode.backtrace_which_we_call_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC77 {

    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n + 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        backTrace(1, nums, k);
        return ans;
    }

    public void backTrace(int start, int[] nums, int k) {
        if (k == path.size()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backTrace(i + 1, nums, k);
            path.removeLast();
        }
    }
}
