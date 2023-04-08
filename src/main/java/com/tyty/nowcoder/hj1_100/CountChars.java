package com.tyty.nowcoder.hj1_100;

import java.util.Scanner;

public class CountChars {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            char[] chars = line.toCharArray();
            //中英文字符，空格字符，数字字符，其他字符
            int letter = 0, space = 0, digit = 0, otherChar = 0;
            for (int i = 0; i < chars.length; i++) {
                if (Character.isLetter(chars[i])) {
                    letter++;
                    continue;
                } else if (Character.isDigit(chars[i])) {
                    digit++;
                    continue;
                } else if (' ' == chars[i]) {
                    space++;
                    continue;
                }
                otherChar++;
            }
            System.out.println(letter);
            System.out.println(space);
            System.out.println(digit);
            System.out.println(otherChar);
        }
    }
}
