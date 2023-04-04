package com.example.nowcoder.hj1_100;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 匈牙利算法是啥
 * todo
 *
 */
public class PrimeNumberPartner {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }
        int[] result = getPartnersNumbers(numbers);
        int max = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] > max) {
                max = result[i];
            }
        }
        System.out.println(max);
    }

    /**
     * 两两相加的个数为Cn2
     *
     * @param numbers
     * @return
     */
    public static int[] getPartnersNumbers(int[] numbers) {
        //n*(n-1) * 1/2
//        int[][] partners = new int[numbers.length - 1][numbers.length / 2];
        int[] result = new int[numbers.length - 1];
        for (int i = 0; i < numbers.length; i++) {
            int count = 0;
            for (int j = i + 1; j < numbers.length; j++) {
//                partners[i][j] = numbers[i] + numbers[j];
                int sum = numbers[i] + numbers[j];
                if (isPrime(sum)) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }

    public static boolean isPrime(int number) {
        boolean prime = true;
        if (number == 2) {
            return prime;
        }


        return primeSet.contains(number);
    }

    public static HashSet<Integer> primeSet = new HashSet<>();

    static {
        for (int i = 2; i <= 30000; i++) {
//定义一个逻辑值flag，初始值为true
            boolean flag = true;
//内层循环遍历除数j(注意：此处若不取边界，则当i=4时，j=2会因为小于i/2=2而直接跳出内循环)
            for (int j = 2; j <= (i / 2); j++) {
//判断是否存在除数j能整除i，若存在，则修改flag的值并跳出循环
                if (0 == i % j) {
                    flag = false;
                    break;
                }
            }
//根据flag的值判断是否输出i
            if (flag) {
                primeSet.add(i);
            }
        }
    }
}
