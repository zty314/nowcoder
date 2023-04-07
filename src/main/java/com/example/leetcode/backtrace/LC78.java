package com.example.leetcode.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC78 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backTrace(0, nums);
        return ans;
    }

    public void backTrace(int start, int[] nums) {
        ans.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backTrace(i + 1, nums);
            path.removeLast();
        }
    }
}
