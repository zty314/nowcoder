package com.tyty.leetcode.backtrace_which_we_call_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC216 {

    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int currSum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k > n) {
            return new ArrayList<>();
        }
        backTrace(k, n, 1);
        return ans;
    }

    public void backTrace(int k, int n, int start) {
        if (currSum == n && path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (path.size() >= k) {
            return;
        }
        for (int i = start; i < 10; i++) {
            if (i > n) {
                return;
            }
            currSum = currSum + i;
            path.add(i);
            backTrace(k, n, i + 1);
            path.removeLast();
            currSum = currSum - i;
        }

    }
}
