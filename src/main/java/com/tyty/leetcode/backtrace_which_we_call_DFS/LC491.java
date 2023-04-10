package com.tyty.leetcode.backtrace_which_we_call_DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LC491 {

    static List<List<Integer>> ans = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    static boolean[] used;

    public static List<List<Integer>> findSubsequences(int[] nums) {
        used = new boolean[nums.length];
        backTrace(nums, 0);
        return ans;
    }

    public static void backTrace(int[] nums, int start) {
        if (path.size() >= 2) {
            ans.add(new ArrayList<>(path));
        }
        // 用哈希集合防止重复选择相同元素
        HashSet<Integer> used = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (path.size() > 0 && nums[i] < path.getLast()) {
                continue;
            }
            // 保证不要重复使用相同的元素
            if (used.contains(nums[i])) {
                continue;
            }
            used.add(nums[i]);
            path.add(nums[i]);
            backTrace(nums, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(findSubsequences(new int[]{4, 4, 3, 2, 1}));
    }
}
