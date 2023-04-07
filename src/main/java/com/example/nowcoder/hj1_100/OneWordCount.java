package com.example.nowcoder.hj1_100;

import java.util.Scanner;

/**
 * 描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 * <p>
 * 数据范围：
 * 1≤n≤1000
 * 输入描述：
 * 第一行输入一个由字母、数字和空格组成的字符串，第二行输入一个字符（保证该字符不为空格）。
 * <p>
 * 输出描述：
 * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
 */
public class OneWordCount {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] chars = str.toLowerCase().toCharArray();
        char c = in.nextLine().toLowerCase().toCharArray()[0];
        int x = 0;
        for (int i = 0; i < chars.length; i++) {
            if (c == chars[i]) {
                x++;
            }
        }
        System.out.println(x);
    }
}
