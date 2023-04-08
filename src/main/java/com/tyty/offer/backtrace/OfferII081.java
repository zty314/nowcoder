package com.tyty.offer.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OfferII081 {

    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    int currentSum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        backTrace(candidates,target,0);
        return ans;
    }

    public void backTrace(int[] candidates, int target, int start) {
        if (target == currentSum) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if(target < currentSum){
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if(target < candidates[i]){
                continue;
            }
            currentSum = currentSum + candidates[i];
            path.add(candidates[i]);
            backTrace(candidates, target, i);
            path.removeLast();
            currentSum = currentSum - candidates[i];
        }
    }
}
