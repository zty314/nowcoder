package com.example.nowcoder.hj1_100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 描述
 * 给定 n 个字符串，请对 n 个字符串按照字典序排列。
 * <p>
 * 数据范围：
 * 1≤n≤1000  ，
 * 字符串长度满足
 * <p>
 * 1≤len≤100
 * 输入描述：
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出描述：
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 */
public class SortStrings {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer counter = Integer.valueOf(in.nextLine());
        List<String> strings = new ArrayList<String>();
        for (int i = 0; i < counter; i++) {
            String s = in.nextLine();
            strings.add(s);
        }
        strings.stream().sorted().forEach(System.out::println);
    }
}
