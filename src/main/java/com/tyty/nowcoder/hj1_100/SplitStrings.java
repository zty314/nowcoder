package com.tyty.nowcoder.hj1_100;

import java.util.Scanner;

/**
 * 描述
 * •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
 * <p>
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述：
 * 连续输入字符串(每个字符串长度小于等于100)
 * <p>
 * 输出描述：
 * 依次输出所有分割后的长度为8的新字符串
 */
public class SplitStrings {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String next = in.next().trim();
            if (next.length() == 0) {
                continue;
            }
            int i = next.toCharArray().length / 8;
            int j = next.toCharArray().length % 8;

            for (int k = 0; k < i; k++) {
                String s = next.substring(k * 8, 8 + k * 8);
                System.out.println(s);
            }

            if (j == 0) {
                continue;
            }
            StringBuffer stringBuffer = new StringBuffer(next.substring(8 * i));
            for (int k = 0; k < 8 - j; k++) {
                stringBuffer.append("0");
            }
            System.out.println(stringBuffer);
        }

    }
}
