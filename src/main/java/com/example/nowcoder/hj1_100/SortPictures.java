package com.example.nowcoder.hj1_100;

import java.util.Arrays;
import java.util.Scanner;

public class SortPictures {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chars = in.nextLine().toCharArray();

        Arrays.sort(chars);
        System.out.println(chars);
    }
}
