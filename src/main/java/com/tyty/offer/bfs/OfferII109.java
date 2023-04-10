package com.tyty.offer.bfs;

import java.util.HashSet;
import java.util.LinkedList;

public class OfferII109 {

    public int openLock(String[] deadends, String target) {
        HashSet<String> deadSet = new HashSet<String>();
        for (String deadend : deadends) {
            deadSet.add(deadend);
        }
        LinkedList<String> queue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        queue.add("0000");
        visited.add("0000");
        int counter = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String current = queue.poll();
                if (deadSet.contains(current)) {
                    continue;
                }
                if (target.equals(current)) {
                    return counter;
                }
                for (int i = 0; i < 4; i++) {
                    String plusOne = plusOne(current, i);
                    if (!visited.contains(plusOne)) {
                        queue.offer(plusOne);
                        visited.add(plusOne);
                    }
                    String minusOne = minusOne(current, i);
                    if (!visited.contains(minusOne)) {
                        queue.offer(minusOne);
                        visited.add(minusOne);
                    }
                }
            }
            counter++;
        }
        return -1;
    }

    public String plusOne(String current, int index) {
        char[] chars = current.toCharArray();
        if (chars[index] == '9') {
            chars[index] = '0';
        } else {
            chars[index] = (char) (chars[index] + 1);
        }
        return new String(chars);
    }

    public String minusOne(String current, int index) {
        char[] chars = current.toCharArray();
        if (chars[index] == '0') {
            chars[index] = '9';
        } else {
            chars[index] = (char) (chars[index] - 1);
        }
        return new String(chars);
    }
}
