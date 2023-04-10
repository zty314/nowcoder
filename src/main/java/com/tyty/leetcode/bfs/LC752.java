package com.tyty.leetcode.bfs;

import java.util.*;

public class LC752 {

    public static int openLock(String[] deadends, String target) {
        for (int i = 0; i < deadends.length; i++) {
            if("0000".equals(deadends[i])) {
                return -1;
            }
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));

        queue.offer("0000");
        visited.add("0000");

        int counter = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(target)) {
                    return counter;
                }
                /* 将一个节点的未遍历相邻节点加入队列 */
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(poll, j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(poll, j);
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            counter++;
        }
        return -1;
    }

    // 将 s[j] 向上拨动一次
    static String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }

    // 将 s[i] 向下拨动一次
    static String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202");
    }
}
