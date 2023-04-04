package com.example.nowcoder.hj1_100;

import java.util.Scanner;

public class SpiltPassword {
    /**
     * 动态规划
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        /*char[] chars = line.toCharArray();
        int maxLength = 0;
        for (int i = 0; i < chars.length; i++) {
            int tempLength = 0;
            for (int j = i + 1, k = i - 1; j < chars.length && k >= 0;
                 j++, k--) {
                if (chars[j] == chars[k]) {
                    tempLength += 2;
                }
            }
            if (tempLength > maxLength) {
                maxLength = tempLength;
            }
        }
        System.out.println(maxLength);*/
        palindrome1(line);
    }


    public static void palindrome1(String str) {

        if (str == null || str.length() == 0) {
            return;
        }
        char[] chs = str.toCharArray();
        int maxLen = 0;
        boolean f[][] = new boolean[chs.length][chs.length];
        for (int j = 0; j < str.length(); j++) {
            f[j][j] = true;
            //一个元素肯定是回文串。
            for (int i = 0; i < j; i++) {
                f[i][j] = chs[j] == chs[i] && (j - i < 2 || f[i + 1][j - 1]);
                //如果chs[j]==chs[i]当串的长度小于等于2时，肯定是回文子串，如 1，1，就是回文串。
                //如果长度大于2时，则需要判断f[i+1][j-1]是不是回文。
                if (f[i][j]) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
                //max_len保存最大回文子串的长度。
            }
        }
        System.out.println(maxLen);
    }
}
