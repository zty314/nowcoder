package com.tyty.leetcode.backtrace_which_we_call_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC15_2 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, 4, 0, target);
    }

    private List<List<Integer>> nSum(int[] nums, int n, int start, long target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n < 2 || len < n) {
            return res;
        }
        if (n == 2) {
            int small = start, big = len - 1;
            while (small < big) {
                int left = nums[small], right = nums[big];
                int sum = left + right;
                if (sum == target) {
                    res.add(new ArrayList<Integer>(Arrays.asList(left, right)));
                    while (small < big && nums[small] == left) {
                        small++;
                    }
                    while (small < big && nums[big] == right) {
                        big--;
                    }
                } else if (sum > target) {
                    while (small < big && nums[big] == right) {
                        big--;
                    }
                } else if (sum < target) {
                    while (small < big && nums[small] == left) {
                        small++;
                    }
                }
            }
        } else {
            int i = start;
            while (i < len) {
                int now = nums[i];
                List<List<Integer>> sub = nSum(nums, n - 1, i + 1, target - now);
                for (List<Integer> s : sub) {
                    s.add(now);
                    res.add(s);
                }
                while (i < len && nums[i] == now) {
                    i++;
                }
            }
        }
        return res;
    }
}
