package com.example.leetcode.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC39 {

    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Arrays.sort(candidates);
        backTrace(0, target, candidates);
        return ans;
    }

    private void backTrace(int start, int target, int[] candidates) {
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
//            if (target < candidates[i]) {
//                return;
//            }
            path.add(candidates[i]);
            sum = sum + candidates[i];
            backTrace(i, target, candidates);
            sum = sum - candidates[i];
            path.removeLast();
        }
    }
}
