package com.tyty.leetcode.backtrace_which_we_call_DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC17 {

    static List<String> ans = new ArrayList<>();

    static StringBuilder path = new StringBuilder();

    public static List<String> letterCombinations(String digits) {
        if(digits.isBlank()){
            return new ArrayList<>();
        }
        backTrace(digits, 0);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static void backTrace(String digits, int start) {
        if (digits.length() == path.length()) {
            ans.add(new String(path));
            return;
        }
        //遍历数字
        for (int i = start; i < digits.length(); i++) {
            char c = digits.toCharArray()[i];
            //遍历字母
            for (int j = 0; j < numMap.get(c).length(); j++) {
                path.append(numMap.get(c).charAt(j));
                backTrace(digits, i + 1);
                path.deleteCharAt(path.length() - 1);
            }

        }
    }

    static HashMap<Character, String> numMap = new HashMap<>();

    static {
        numMap.put('2', "abc");
        numMap.put('3', "def");
        numMap.put('4', "ghi");
        numMap.put('5', "jkl");
        numMap.put('6', "mno");
        numMap.put('7', "pqrs");
        numMap.put('8', "tuv");
        numMap.put('9', "wxyz");
    }
}
