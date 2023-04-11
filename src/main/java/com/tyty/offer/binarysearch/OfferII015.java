package com.tyty.offer.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OfferII015 {
    public List<Integer> findAnagrams(String source, String target) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : target.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < source.length()) {
            char c = source.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right - left == target.length()) {
                    ans.add(left);
                }
                char d = source.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return ans;
    }
}
