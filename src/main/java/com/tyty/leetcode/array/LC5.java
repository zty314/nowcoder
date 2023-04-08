package com.tyty.leetcode.array;

public class LC5 {

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {

            String p1 = palindrome(s, i, i);
            String p2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > p1.length() ? res : p1;
            res = res.length() > p2.length() ? res : p2;
        }
        return res;
    }

    // 在 s 中寻找以 s[l] 和 s[r] 为中心的最长回文串
    String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            // 双指针，向两边展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);
    }
}
