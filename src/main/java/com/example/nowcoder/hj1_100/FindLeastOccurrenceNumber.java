package com.example.nowcoder.hj1_100;

import java.util.HashMap;
import java.util.Scanner;

public class FindLeastOccurrenceNumber {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        char[] chars = in.nextLine().toCharArray();
        HashMap<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            dict.put(chars[i], dict.getOrDefault(chars[i], 0) + 1);
        }
        int min = 20;
        for (HashMap.Entry<Character, Integer> entry : dict.entrySet()) {
            if (min > entry.getValue()) {
                min = entry.getValue();
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            Integer count = dict.get(chars[i]);
            if (count != min) {
                builder.append(chars[i]);
            }
        }
        System.out.println(builder);
    }
}

