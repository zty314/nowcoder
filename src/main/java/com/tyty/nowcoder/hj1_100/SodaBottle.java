package com.tyty.nowcoder.hj1_100;

import java.util.Scanner;

public class SodaBottle {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        while (in.hasNextInt()) {

            int emptyBottles = in.nextInt();
            if (0 == emptyBottles) {
                break;
            }

            int totalFinishedBottles = 0;

            builder.append(countBottles(emptyBottles, totalFinishedBottles)).append("\n");
        }
        System.out.println(builder);
    }

    /**
     * 可以借空瓶的情况：
     * 剩1个空瓶 -- 借2个空瓶 -- 喝完剩1个空瓶，还不上。
     * 剩2个空瓶 -- 借1个空瓶 -- 喝完剩1个空瓶，还上空瓶。
     * 可以转换为，剩2空瓶时，可以多喝1瓶
     *
     * @param emptyBottles
     * @param totalFinishedBottles
     */
    public static int countBottles(int emptyBottles, int totalFinishedBottles) {
        int remainderBottles = emptyBottles % 3;

        int finishedBottles = emptyBottles / 3;

        totalFinishedBottles += finishedBottles;
        if (remainderBottles + finishedBottles == 2) {
            return totalFinishedBottles + 1;
        } else if (remainderBottles + finishedBottles >= 3) {
            return countBottles(remainderBottles + finishedBottles, totalFinishedBottles);
        } else {
            return totalFinishedBottles;
        }
    }

}
