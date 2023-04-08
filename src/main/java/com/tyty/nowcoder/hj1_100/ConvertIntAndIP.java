package com.tyty.nowcoder.hj1_100;

import java.util.Scanner;

public class ConvertIntAndIP {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String ip = in.nextLine();
        String number = in.nextLine();

        long convertIP = convertIP(ip);
        String convertInt = convertInt(Long.parseLong(number));
        System.out.println(convertIP);
        System.out.println(convertInt);
    }

    public static String convertInt(long number) {
        String binaryString = Long.toBinaryString(number);
        if (binaryString.length() < 32) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 32 - binaryString.length(); i++) {
                builder.append("0");
            }
            builder.append(binaryString);
            binaryString = builder.toString();
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 32; i += 8) {
            String substring = binaryString.substring(i, i + 8);
            long value = Long.valueOf(substring, 2);
            builder.append(value).append('.');
        }

        return builder.substring(0, builder.length() - 1);
    }

    public static long convertIP(String ip) {
        String[] ips = ip.split("\\.");
        long one = Long.parseLong(ips[0]);
        long two = Long.parseLong(ips[1]);
        long three = Long.parseLong(ips[2]);
        long four = Long.parseLong(ips[3]);

        String binOne = Long.toBinaryString(one);
        String binTwo = Long.toBinaryString(two);
        String binThree = Long.toBinaryString(three);
        String binFour = Long.toBinaryString(four);

        String appendedOne = appendZero(binOne);
        String appendedTwo = appendZero(binTwo);
        String appendedThree = appendZero(binThree);
        String appendedFour = appendZero(binFour);

        StringBuilder builder = new StringBuilder()
                .append(appendedOne).append(appendedTwo).append(appendedThree).append(appendedFour);

        return Long.valueOf(builder.toString(), 2);
    }

    public static String appendZero(String bin) {
        if (bin.length() < 8) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 8 - bin.length(); i++) {
                builder.append("0");
            }
            builder.append(bin);
            return builder.toString();
        }
        return bin;
    }
}
