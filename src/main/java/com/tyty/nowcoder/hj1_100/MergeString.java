package com.tyty.nowcoder.hj1_100;

import java.util.Arrays;
import java.util.Scanner;

public class MergeString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String replace = in.nextLine().replace(" ", "");

        char[] orgChars = replace.toCharArray();
//        HashMap<Character, Integer> map = new HashMap<>(orgChars.length);
        char[] evenChars = new char[orgChars.length % 2 == 0 ? orgChars.length / 2 : orgChars.length / 2 + 1];
        int evenIndex = 0;
        char[] oddChars = new char[orgChars.length / 2];
        int oddIndex = 0;

        for (int i = 0; i < orgChars.length; i++) {
//            map.put(orgChars[i], i);
            if (i % 2 == 0) {
                evenChars[evenIndex] = orgChars[i];
                evenIndex++;
            } else {
                oddChars[oddIndex] = orgChars[i];
                oddIndex++;
            }
        }
        Arrays.sort(evenChars);
        Arrays.sort(oddChars);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < orgChars.length; i++) {
            if (i % 2 == 0) {
                builder.append(evenChars[i / 2]);
            } else {
                builder.append(oddChars[i / 2]);
            }
        }

        //3.对字符进行转换操作
        for (int i = 0; i < builder.length(); i++) {
            String s = builder.substring(i, i + 1);
            if (s.matches("[0-9a-fA-F]")) {
                //把16进制转成10进制，再转成二进制
                StringBuilder binary = new StringBuilder(Integer.toBinaryString(Integer.parseInt(s, 16)));
                int len = binary.length();
                for (int j = 0; j < 4 - len; j++) { //补零
                    binary.insert(0, "0");
                }
                binary = binary.reverse();//翻转
                int n = Integer.parseInt(binary.toString(), 2); //把二进制转成10进制
                String hexString = Integer.toHexString(n).toUpperCase();//转成16进制字符串大写
                builder.replace(i, i + 1, hexString);//替换
            }
        }
        System.out.println(builder);

    }
}
