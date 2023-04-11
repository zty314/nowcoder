package com.tyty.leetcode.backtrace_which_we_call_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC15 {

    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backTrace(nums, visited, 0);
        return ans;
    }

    public void backTrace(int[] nums, boolean[] visited, int start) {
        if (path.size() == 3) {
            if (path.get(0) + path.get(1) + path.get(2) == 0) {
                ans.add(Arrays.asList(path.get(0), path.get(1), path.get(2)));
            }
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > start && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            backTrace(nums,visited,i+1);
            path.removeLast();
            visited[i] = false;
        }
    }
}
