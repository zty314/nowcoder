package com.tyty.nowcoder.hj1_100;

import java.util.Scanner;

/**
 * 描述
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 * <p>
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 * <p>
 * 数据范围：输入的字符串长度满足
 * <p>
 * 1≤n≤1000
 * <p>
 * 注意本题有多组输入
 * 输入描述：
 * 输入一个英文语句，每个单词用空格隔开。保证输入只包含空格和字母。
 * <p>
 * 输出描述：
 * 得到逆序的句子
 */
public class ReverseSentence {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String[] strings = in.nextLine().split(" ");
            for (int i = strings.length - 1; i >= 0; i--) {
                System.out.print(strings[i] + " ");
            }
        }
    }
}
