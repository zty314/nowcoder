package com.example.offer.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OfferII080 {

    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        boolean[] visited = new boolean[n + 1];
        backTrace(n, k, 1, visited);

        return ans;
    }

    public void backTrace(int n, int k, int start, boolean[] visited) {
        if (k == path.size()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < n + 1; i++) {
            if(visited[i]){
                continue;
            }
            path.add(i);
            visited[i] = true;
            backTrace(n, k, i + 1, visited);
            path.removeLast();
            visited[i] = false;
        }
    }
}
