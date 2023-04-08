package com.tyty.leetcode.backtrace_which_we_call_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC46 {
    LinkedList<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, track, visited);
        return ans;
    }

    private void dfs(int[] nums, LinkedList<Integer> track, boolean[] visited) {
        if (track.size() == nums.length) {
            ans.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            track.add(nums[i]);
            dfs(nums, track, visited);
            track.removeLast();
            visited[i] = false;
        }
    }
}
