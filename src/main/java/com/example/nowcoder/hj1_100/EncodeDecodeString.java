package com.example.nowcoder.hj1_100;

import java.util.Scanner;

public class EncodeDecodeString {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String toEncode = in.nextLine();
        String toDecode = in.nextLine();
        System.out.println(encode(toEncode));
        System.out.println(Decode(toDecode));

    }

    public static String encode(String toEncode) {
        char[] chars = toEncode.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                if (chars[i] == 'Z') {
                    chars[i] = 'a';
                } else if (chars[i] == 'z') {
                    chars[i] = 'A';
                } else if (Character.isUpperCase(chars[i])) {
                    chars[i] = (char) (Character.toLowerCase(chars[i]) + 1);
                } else if (Character.isLowerCase(chars[i])) {
                    chars[i] = (char) (Character.toUpperCase(chars[i]) + 1);
                }
            } else if (Character.isDigit(chars[i])) {
                if (chars[i] == '9') {
                    chars[i] = '0';
                } else {
                    chars[i] = (char) (chars[i] + 1);
                }
            }

        }
        return String.copyValueOf(chars);
    }

    public static String Decode(String toDecode) {
        char[] chars = toDecode.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                if (chars[i] == 'a') {
                    chars[i] = 'Z';
                } else if (chars[i] == 'A') {
                    chars[i] = 'z';
                } else if (Character.isUpperCase(chars[i])) {
                    chars[i] = (char) (Character.toLowerCase(chars[i]) - 1);
                } else if (Character.isLowerCase(chars[i])) {
                    chars[i] = (char) (Character.toUpperCase(chars[i]) - 1);
                }
            } else if (Character.isDigit(chars[i])) {
                if (chars[i] == '0') {
                    chars[i] = '9';
                } else {
                    chars[i] = (char) (chars[i] - 1);
                }
            }

        }
        return String.copyValueOf(chars);
    }
}
