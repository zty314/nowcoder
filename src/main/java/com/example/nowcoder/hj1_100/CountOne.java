package com.example.nowcoder.hj1_100;

import java.util.Scanner;

/**
 * 描述
 * 输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
 * <p>
 * 数据范围：保证在 32 位整型数字范围内
 * 输入描述：
 * 输入一个整数（int类型）
 * <p>
 * 输出描述：
 * 这个数转换成2进制后，输出1的个数
 */
public class CountOne {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer integer = in.nextInt();
        String str = Integer.toString(integer, 2);
        int c = 0;
        for (int i = 0; i < str.length(); i++) {
            char cc = str.toCharArray()[i];
            if (cc == '1') {
                c++;
            }
        }
        System.out.println(c);

    }
}
