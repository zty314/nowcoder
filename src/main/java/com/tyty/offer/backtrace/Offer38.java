package com.tyty.offer.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer38 {

    StringBuilder builder = new StringBuilder();

    List<String> list = new ArrayList<>();

    boolean[] used;

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        used = new boolean[s.length()];
        Arrays.sort(chars);
        backTrace(chars);
        String[] ans = new String[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public void backTrace(char[] chars) {
        if (builder.length() == chars.length) {
            list.add(new String(builder));
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            builder.append(chars[i]);
            backTrace(chars);
            builder.deleteCharAt(builder.length() - 1);
            used[i] = false;
        }
    }
}
