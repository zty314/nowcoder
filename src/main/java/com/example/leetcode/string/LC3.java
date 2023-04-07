package com.example.leetcode.string;

import java.util.HashSet;

public class LC3 {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int maxLength = 0;
        for (int i = 0; i < chars.length; i++) {
            HashSet<Character> set = new HashSet<>();
            set.add(chars[i]);
            int tempLength = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (set.add(chars[j])) {
                    tempLength++;
                } else {
                    break;
                }
            }
            maxLength = Math.max(maxLength, tempLength);
        }
        return maxLength;
    }
}