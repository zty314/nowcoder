package com.tyty.nowcoder.hj1_100;

import java.util.Scanner;

/**
 * 描述
 * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
 * 输入描述：
 * 输入一行，代表要计算的字符串，非空，长度小于5000。
 * 输出描述：
 * 输出一个整数，表示输入字符串最后一个单词的长度。
 */
public class LastWordLength {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int length = str.length();
        int count = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') { // 或者 if (str.substring(i, i + 1).equals(" ")) {
                break;
            }
            count++;
        }
        System.out.println(count);
    }
}
