package com.tyty.nowcoder.hj1_100;

import java.util.ArrayList;
import java.util.Scanner;

public class CheckPassword {


    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            boolean length = checkLength(line);
            boolean mutiType = checkMutiType(line);
            boolean subString = checkSubString(line);
            arrayList.add(length && mutiType && subString ? "OK" : "NG");
        }
        arrayList.forEach(s -> System.out.println(s + " "));
    }

    public static boolean checkLength(String line) {
        return line.length() >= 8;
    }

    public static boolean checkMutiType(String line) {
        boolean upperCheck = false;
        boolean lowerCheck = false;
        boolean numberCheck = false;
        boolean specialCheck = false;

        char[] chars = line.toCharArray();
        for (int i = 0; i < line.length(); i++) {
            //大写字母
            if (Character.isUpperCase(chars[i])) {
                upperCheck = true;
            }
            //小写字母
            if (Character.isLowerCase(chars[i])) {
                lowerCheck = true;
            }
            //数字
            if (Character.isDigit(chars[i])) {
                numberCheck = true;
            }
            //特殊字符
            if (!Character.isDigit(chars[i]) && !Character.isLetter(chars[i]) && chars[i] != ' ' && chars[i] != '\n') {
                specialCheck = true;
            }
        }

        int count = 0;
        if (upperCheck) {
            count++;
        }
        if (lowerCheck) {
            count++;
        }
        if (numberCheck) {
            count++;
        }
        if (specialCheck) {
            count++;
        }

        return count >= 3;
    }

    /**
     * 滑窗法，窗口>2
     * 若有3+n长度的两个相同子串，则一定有3长度的两个相同子串
     * 左指针+1
     *
     * @param line
     * @return
     */
    public static boolean checkSubString(String line) {
        char[] chars = line.toCharArray();
        int left = 0, length = 3;
        for (; left < chars.length - length; left++) {
            //初始化窗口
            char[] window = new char[length];
            for (int i = 0; i < length; i++) {
                window[i] = chars[left + i];
            }
            //开始滑动
            for (int i = length + left; i < chars.length - length; i++) {
                if (chars[i] == window[0] && chars[i + 1] == window[1] && chars[i + 2] == window[2]) {
                    return false;
                }
            }
        }
        return true;
    }
}
