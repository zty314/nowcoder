package com.example.leetcode.backtrace;

import java.util.ArrayList;
import java.util.List;

public class LC52 {
    int ans = 0;

    public int totalNQueens(int n) {
        List<String> chessboard = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder bu = new StringBuilder();
            for (int j = 0; j < n; j++) {
                bu.append(".");
            }
            chessboard.add(bu.toString());
        }
        backTrace(chessboard, 0);

        return ans;
    }

    public void backTrace(List<String> chessboard, int row) {
        if (row == chessboard.size()) {
//            ans.add(new ArrayList<>(chessboard));
            ans++;
            return;
        }
        for (int i = 0; i < chessboard.size(); i++) {
            if (!isValid(chessboard, row, i)) {
                continue;
            }
            String line = chessboard.get(row);
            StringBuilder builder = new StringBuilder(line);
            builder.setCharAt(i, 'Q');
            chessboard.set(row, builder.toString());
            backTrace(chessboard, row + 1);
            chessboard.set(row, line);
        }
    }

    public boolean isValid(List<String> chessboard, int row, int position) {
        for (int i = row - 1; i >= 0; i--) {
            if (chessboard.get(i).charAt(position) == 'Q') {
                return false;
            }
        }
        //检查左上方
        for (int i = row - 1, j = position - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        //检查右上方
        for (int i = row - 1, j = position + 1; i >= 0 && j < chessboard.size(); i--, j++) {
            if (chessboard.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }

//    public static void main(String[] args) {
//        System.out.println(solveNQueens(4));
//    }
}
