package com.tyty.nowcoder.hj1_100;

import java.util.Scanner;

//DP
public class CountRabbit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int month = in.nextInt();
        int r1 = 0, r2 = 0, r3 = 0;
        for (int i = 0; i < month; i++) {
            r3 = r2 + r1;
            r2 = r1;
            if (r3 == 0 && r2 == 0) {
                r1 = 1;
            } else if (r3 == 0 && r2 == 1) {
                r1 = 0;
            } else {
                r1 = r3;
            }

        }
        System.out.println(r1 + r2 + r3);

    }
}
