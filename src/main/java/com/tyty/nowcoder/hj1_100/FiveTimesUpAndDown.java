package com.tyty.nowcoder.hj1_100;

import java.util.Scanner;

public class FiveTimesUpAndDown {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double height = in.nextDouble();
            System.out.println(height + (height / 2) * 2 + (height / 4) * 2 + (height / 8) * 2 + (height / 16) * 2);
            System.out.println(height / 32);

        }
    }
}
