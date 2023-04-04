package com.example.nowcoder.hj1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FindBrotherWord {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer n = in.nextInt();
        String[] brotherWords = new String[n];
        for (int i = 0; i < n; i++) {
            brotherWords[i] = in.next();
        }
        String x = in.next();
        Integer k = in.nextInt();


        sortBrotherWords(brotherWords);

        StringBuilder builder = new StringBuilder();
        ArrayList<String> objects = new ArrayList<>();
        for (int i = 0; i < brotherWords.length; i++) {
            if (isBrotherWord(x, brotherWords[i])) {
                objects.add(brotherWords[i]);
            }
        }
        builder.append(objects.size());
        if (objects.size() > 0 && objects.size() >= k - 1) {
            builder.append("\n").append(objects.get(k - 1));
        }

        System.out.println(builder);
    }

    public static String[] sortBrotherWords(String[] brotherWords) {
        Arrays.sort(brotherWords);
        return brotherWords;
    }

    public static boolean isBrotherWord(String x, String brotherWord) {
        if (x.length() != brotherWord.length()) {
            return false;
        }
        if (x.equals(brotherWord)) {
            return false;
        }
        char[] xChars = x.toCharArray();
        char[] broChars = brotherWord.toCharArray();

        boolean found = true;

        for (int i = 0; i < xChars.length; i++) {
            for (int j = 0; j < broChars.length; j++) {
                if (xChars[i] == broChars[j]) {
                    broChars[j] = ' ';
                    break;
                }
            }

        }


        for (int i = 0; i < broChars.length; i++) {
            if (broChars[i] != ' ') {
                found = false;
                break;
            }
        }
        return found;
    }
}
