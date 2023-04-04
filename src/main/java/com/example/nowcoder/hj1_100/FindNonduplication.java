package com.example.nowcoder.hj1_100;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 描述
 * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是 0 。
 * <p>
 * 数据范围：
 * 1≤n≤10
 * <p>
 * 输入描述：
 * 输入一个int型整数
 * <p>
 * 输出描述：
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 */
public class FindNonduplication {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chars = in.nextLine().toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);
            System.out.print(chars[i]);
        }

    }
}
