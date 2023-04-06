package com.example.offer.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OfferII083 {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        LinkedList<Integer> trace = new LinkedList<>();
        backTrace(visited, nums, trace);
        return ans;
    }

    private void backTrace(boolean[] visited, int[] nums, LinkedList<Integer> trace) {
        if (trace.size() == nums.length) {
            ans.add(new ArrayList<>(trace));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            trace.add(nums[i]);
            visited[i] = true;
            backTrace(visited,nums,trace);
            trace.removeLast();
            visited[i] = false;
        }
    }
}
