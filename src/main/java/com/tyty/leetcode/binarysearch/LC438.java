package com.tyty.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC438 {

    public static List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int valid = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    ans.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> anagrams = findAnagrams("cbaebabacd", "abc");
        System.out.println(anagrams);
    }
}
