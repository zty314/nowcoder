package com.tyty.nowcoder.hj1_100;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 描述
 * 数据表记录包含表索引index和数值value（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照index值升序进行输出。
 * <p>
 * 提示:
 * 0 <= index <= 11111111
 * 1 <= value <= 100000
 * <p>
 * 输入描述：
 * 先输入键值对的个数n（1 <= n <= 500）
 * 接下来n行每行输入成对的index和value值，以空格隔开
 * <p>
 * 输出描述：
 * 输出合并后的键值对（多行）
 */
public class MergeRecord {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = Integer.parseInt(in.nextLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a; i++) {
            String s = in.nextLine();
            String[] s1 = s.split(" ");
            Integer integer = map.get(Integer.valueOf(s1[0])) == null ? 0 : map.get(Integer.valueOf(s1[0]));
            map.put(Integer.valueOf(s1[0]), integer + Integer.valueOf(s1[1]));
        }
        map.keySet().stream().sorted().forEach(key -> System.out.println(key + " " + map.get(key)));
    }
}
