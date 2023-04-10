package com.tyty.leetcode.binarysearch;

import java.util.HashMap;

public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int ans = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            right++;
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                window.put(d, window.get(d) - 1);
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }

}
