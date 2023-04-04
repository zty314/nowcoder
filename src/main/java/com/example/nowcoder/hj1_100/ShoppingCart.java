package com.example.nowcoder.hj1_100;

import java.util.Scanner;

/**
 * 动态规划问题
 * https://www.nowcoder.com/practice/f9c6f980eeec43ef85be20755ddbeaf4?tpId=37&tags=&title=&difficulty=&judgeStatus
 * =&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&gioEnter=menu
 */
public class ShoppingCart {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int n = sc.nextInt();
        if (n <= 0 || money <= 0) {
            System.out.println(0);
        }

        good[] Gs = new good[n + 1];
        for (int i = 1; i <= n; i++) {
            int v = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            if(null != Gs[i]){
                Gs[i].v = v;
                Gs[i].p = p;
                Gs[i].q = q;
            }else{
                Gs[i] = new good(v, p, q);
            }

            if (q > 0) {
                if (null == Gs[q]) {
                    Gs[q] = new good(0, 0, 0);
                }
                if (Gs[q].a1 == 0) {
                    Gs[q].setA1(i);
                } else {
                    Gs[q].setA2(i);
                }
            }
        }

        int[][] dp = new int[n + 1][money + 1];
        for (int i = 1; i <= n; i++) {
            int v = 0, v1 = 0, v2 = 0, v3 = 0, tempdp = 0, tempdp1 = 0, tempdp2 = 0, tempdp3 = 0;

            v = Gs[i].v;
            //只有主件
            tempdp = Gs[i].p * v;
            //主件加附件1
            if (Gs[i].a1 != 0) {
                v1 = Gs[Gs[i].a1].v + v;
                tempdp1 = tempdp + Gs[Gs[i].a1].v * Gs[Gs[i].a1].p;
            }
            //主件加附件2
            if (Gs[i].a2 != 0) {
                v2 = Gs[Gs[i].a2].v + v;
                tempdp2 = tempdp + Gs[Gs[i].a2].v * Gs[Gs[i].a2].p;
            }
            //主件加附件1和附件2
            if (Gs[i].a1 != 0 && Gs[i].a2 != 0) {
                v3 = Gs[Gs[i].a1].v + Gs[Gs[i].a2].v + v;
                tempdp3 = tempdp + Gs[Gs[i].a1].v * Gs[Gs[i].a1].p + Gs[Gs[i].a2].v * Gs[Gs[i].a2].p;
            }

            for (int j = 1; j <= money; j++) {
                //当物品i是附件时,相当于跳过
                if (Gs[i].q > 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= v && v != 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v] + tempdp);
                    }
                    if (j >= v1 && v1 != 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v1] + tempdp1);
                    }
                    if (j >= v2 && v2 != 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v2] + tempdp2);
                    }
                    if (j >= v3 && v3 != 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v3] + tempdp3);
                    }
                }
            }
        }
        System.out.println(dp[n][money]);


    }


    /**
     * 定义物品类
     */
    private static class good {
        public int v;  //物品的价格
        public int p;  //物品的重要度
        public int q;  //物品的主附件ID

        public int a1 = 0;   //附件1ID
        public int a2 = 0;   //附件2ID

        public good(int v, int p, int q) {
            this.v = v;
            this.p = p;
            this.q = q;
        }

        public void setA1(int a1) {
            this.a1 = a1;
        }

        public void setA2(int a2) {
            this.a2 = a2;
        }
    }
}
