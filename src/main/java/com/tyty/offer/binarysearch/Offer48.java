package com.tyty.offer.binarysearch;

import java.util.HashMap;

public class Offer48 {

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int len = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
            len = Math.max(right-left,len);
        }
        return len;
    }
}
