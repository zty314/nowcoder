package com.tyty.nowcoder.hj1_100;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimplePassword {

    /**
     * abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        char[] chars = line.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                if (Character.isUpperCase(chars[i])) {
                    if (chars[i] == 'Z') {
                        builder.append('a');
                    } else {
                        builder.append(Character.toChars(Character.toLowerCase(chars[i]) + 1));
                    }
                } else {
                    builder.append(passwordDictionary.get(chars[i]));
                }
            } else {
                builder.append(chars[i]);
            }
        }
        System.out.println(builder);
    }

    public static Map<Character, Integer> passwordDictionary = new HashMap<>();

    static {
        passwordDictionary.put('a', 2);
        passwordDictionary.put('b', 2);
        passwordDictionary.put('c', 2);
        passwordDictionary.put('d', 3);
        passwordDictionary.put('e', 3);
        passwordDictionary.put('f', 3);
        passwordDictionary.put('g', 4);
        passwordDictionary.put('h', 4);
        passwordDictionary.put('i', 4);
        passwordDictionary.put('j', 5);
        passwordDictionary.put('k', 5);
        passwordDictionary.put('l', 5);
        passwordDictionary.put('m', 6);
        passwordDictionary.put('n', 6);
        passwordDictionary.put('o', 6);
        passwordDictionary.put('p', 7);
        passwordDictionary.put('q', 7);
        passwordDictionary.put('r', 7);
        passwordDictionary.put('s', 7);
        passwordDictionary.put('t', 8);
        passwordDictionary.put('u', 8);
        passwordDictionary.put('v', 8);
        passwordDictionary.put('w', 9);
        passwordDictionary.put('x', 9);
        passwordDictionary.put('y', 9);
        passwordDictionary.put('z', 9);
    }
}
