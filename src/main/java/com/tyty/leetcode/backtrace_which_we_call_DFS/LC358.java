package com.tyty.leetcode.backtrace_which_we_call_DFS;

import java.util.ArrayList;
import java.util.List;

public class LC358 {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> largestDivisibleSubset(int[] nums) {

        return ans;
    }

//    public void backTrace(int start, int[] nums) {
//        if (start == nums.length) {
//            return;
//        }
//        for (int i = start; i < nums.length; i++) {
//            if(!isSubCollection(nums,i,j)){
//                continue;
//            }
//            ans.add(nums[i]);
//        }
//    }
//
//    public boolean isSubCollection(int[] num, int start, int end) {
//        return num[start] % num[end] == 0 || num[end] % num[start] == 0;
//    }
}
