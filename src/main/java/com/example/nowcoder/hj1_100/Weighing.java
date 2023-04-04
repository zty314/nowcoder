package com.example.nowcoder.hj1_100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Weighing {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] weight = new int[n];
            for (int i = 0; i < n; i++) {
                weight[i] = in.nextInt();
            }
            int[] number = new int[n];
            for (int i = 0; i < n; i++) {
                number[i] = in.nextInt();
            }
            HashSet<Integer> range = new HashSet<>();
            range.add(0);
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> eachKindWeight = new ArrayList<>(range);
                for (int j = 1; j < number[i] + 1; j++) {
                    for (int k = 0; k < eachKindWeight.size(); k++) {
                        range.add(eachKindWeight.get(k) + weight[i] * j);
                    }
                }
            }
            System.out.println(range.size());
        }

    }
}
