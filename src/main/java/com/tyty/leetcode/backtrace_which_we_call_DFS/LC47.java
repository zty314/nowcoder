package com.tyty.leetcode.backtrace_which_we_call_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC47 {

    static List<List<Integer>> ans = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTrace(nums, used);
        return ans;
    }

    private static void backTrace(int[] nums, boolean[] used) {
        if (nums.length == path.size()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backTrace(nums, used);
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = permuteUnique(new int[]{1, 1, 2});
        System.out.println(lists.toString());
    }
}
