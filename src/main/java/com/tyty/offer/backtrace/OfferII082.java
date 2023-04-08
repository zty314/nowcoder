package com.tyty.offer.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class OfferII082 {

    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int currSum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrace(candidates, target, 0);
        return ans;
    }

    public void backTrace(int[] candidates, int target, int start) {
        if (currSum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if(currSum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            currSum = currSum + candidates[i];
            path.add(candidates[i]);
            backTrace(candidates, target, i + 1);
            path.removeLast();
            currSum = currSum - candidates[i];
        }
    }
}
