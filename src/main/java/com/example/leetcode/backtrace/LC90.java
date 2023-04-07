package com.example.leetcode.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC90 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTrace(0, nums, used);
        return ans;
    }

    public void backTrace(int start, int[] nums, boolean[] used) {
        ans.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > start && nums[i] == nums[i - 1] && !used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backTrace(i + 1, nums, used);
            path.removeLast();
            used[i] = false;
        }
    }
}
