package com.tyty.nowcoder.hj1_100;

import java.util.Scanner;

public class ReverseWords {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        char[] chars = in.nextLine().toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                builder.append(chars[i]);
            } else {
                if (builder.lastIndexOf(" ") == builder.length() - 1) {
                    continue;
                }
                builder.append(" ");
            }
        }
        String[] split = builder.toString().split(" ");
        for (int i = split.length - 1; i >= 0; i--) {
            System.out.print(split[i] + " ");
        }

    }
}
