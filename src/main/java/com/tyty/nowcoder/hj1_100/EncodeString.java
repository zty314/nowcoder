package com.tyty.nowcoder.hj1_100;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class EncodeString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String key = in.nextLine();
        String message = in.nextLine();

        char value = 'a';
        char[] chars = key.toCharArray();
        LinkedHashMap<Character, Character> keyDict = new LinkedHashMap<>();
        int x = 0;
        int y = 0;
        while (keyDict.size() < 26) {
            if (y < chars.length) {
                if (!keyDict.containsValue(chars[y])) {
                    keyDict.put((char) (value + x), chars[y]);
                    x++;
                }
                y++;
                continue;
            } else {
                char tempValue = 'a';
                for (int j = 0; j < 26; j++) {
                    if (!keyDict.containsValue((char) (tempValue + j))) {
                        keyDict.put((char) (value + x), (char) (tempValue + j));
                        break;
                    }
                }
            }
            x++;
        }


        char[] messageChar = message.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < messageChar.length; i++) {
            if (keyDict.containsKey(messageChar[i])) {
                builder.append(keyDict.get(messageChar[i]));
            }
        }
        System.out.println(builder);
    }
}
