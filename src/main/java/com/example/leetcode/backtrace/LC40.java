package com.example.leetcode.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC40 {

    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        backTrace(0, target, candidates, used);
        return ans;
    }

    private void backTrace(int start, int target, int[] candidates, boolean[] used) {
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                continue;
            }
            if (i > start && candidates[i] == candidates[i - 1] && !used[i]) {
                continue;
            }
            used[i] = true;
            path.add(candidates[i]);
            sum = sum + candidates[i];
            backTrace(i + 1, target, candidates, used);
            sum = sum - candidates[i];
            path.removeLast();
            used[i] = false;
        }
    }

}
