package com.example.nowcoder.hj1_100;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OrderString {

    public static String sort(String str) {
        // 先将英文字母收集起来
        List<Character> letters = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                letters.add(ch);
            }
        }
        // 将英文字母先排序好
        letters.sort(new Comparator<Character>() {
            public int compare(Character o1, Character o2) {
                return Character.toLowerCase(o1) - Character.toLowerCase(o2);
            }
        });
        // 若是非英文字母则直接添加
        StringBuilder result = new StringBuilder();
        for (int i = 0, j = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                result.append(letters.get(j++));
            } else {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            String res = sort(str);
            System.out.println(res);
        }
    }

//    public static void quickSort(char[] arr, int start, int end) {
//        if (start > end) {
//            return;
//        }
//        char tmp = arr[start];
//        int i = start;
//        int j = end;
//        while (i != j) {
//            while (Character.toUpperCase(arr[j]) >= Character.toUpperCase(tmp) && j > i) {
//                j--;
//            }
//            while (Character.toUpperCase(arr[i]) <= Character.toUpperCase(tmp) && j > i) {
//                i++;
//            }
//            if (j > i) {
//                char t = arr[i];
//                arr[i] = arr[j];
//                arr[j] = t;
//            }
//        }
//        arr[start] = arr[i];
//        arr[i] = tmp;
//        quickSort(arr, start, i - 1);
//        quickSort(arr, i + 1, end);
//
//    }
}
