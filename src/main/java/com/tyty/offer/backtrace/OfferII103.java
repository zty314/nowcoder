package com.tyty.offer.backtrace;

import java.util.Arrays;

public class OfferII103 {
    public int coinChange(int[] coins, int amount) {
        int[] amounts = new int[amount + 1];
        Arrays.fill(amounts, amount + 1);
        amounts[0] = 0;
        for (int i = 0; i < amount + 1; i++) {
            for (int coin : coins) {
                if (i < coin) {
                    continue;
                }
                //这里的+1，就是将本次coin的面值算上
                amounts[i] = Math.min(amounts[i], amounts[i - coin] + 1);
            }
        }
        return amounts[amount] == amount + 1 ? -1 : amounts[amount];
    }
}
