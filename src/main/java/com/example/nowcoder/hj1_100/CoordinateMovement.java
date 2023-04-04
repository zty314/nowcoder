package com.example.nowcoder.hj1_100;

import java.util.Scanner;

public class CoordinateMovement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String orgData = sc.nextLine();
        String[] splitData = orgData.split(";");
        CMap cMap = new CMap(0, 0);
        for (int i = 0; i < splitData.length; i++) {
            boolean legal = cMap.isLegal(splitData[i]);
            if (legal) {
                cMap.move(splitData[i]);
            }
        }
        System.out.println(cMap);
    }

    public static class CMap {
        public Integer x, y;

        public void move(String action) {
            char[] chars = action.toCharArray();
            Integer offset = Integer.valueOf(action.substring(1));
            if (chars[0] == 'W') {
                this.moveUp(offset);
            }
            if (chars[0] == 'S') {
                this.moveDown(offset);
            }
            if (chars[0] == 'A') {
                this.moveLeft(offset);
            }
            if (chars[0] == 'D') {
                this.moveRight(offset);
            }

        }

        public boolean isLegal(String action) {
            if (null == action || action.length() < 2) {
                return false;
            }
            char[] chars = action.toCharArray();
            boolean direction = chars[0] == 'A' || chars[0] == 'S' || chars[0] == 'D' || chars[0] == 'W';
            if (!direction) {
                return false;
            }
            boolean offset = true;
            for (int i = 1; i < chars.length; i++) {
                if(!Character.isDigit(chars[i])){
                    offset = false;
                    break;
                }
            }
            return offset;
        }

        public CMap(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        public void moveLeft(Integer x) {
            this.x -= x;
        }

        public void moveRight(Integer x) {
            this.x += x;
        }

        public void moveUp(Integer y) {
            this.y += y;
        }

        public void moveDown(Integer y) {
            this.y -= y;
        }

        @Override
        public String toString() {
            return this.x + "," + this.y;
        }
    }
}
