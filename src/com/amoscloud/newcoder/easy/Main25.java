package com.amoscloud.newcoder.easy;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2021/2/25
 * Time: 16:43
 * Description:
 */
public class Main25 {
    public static void main(String[] args) {
        /**
         * 输入
         * -1 -3 7 5 11 15
         * 输出
         * -3 5 2
         */

        Scanner sc = new Scanner(System.in);
        String[] numStr = sc.nextLine().split(" ");
        sc.close();
        int[] ints = new int[numStr.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(numStr[i]);
        }

        int a = 0, b = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                int sum = ints[i] + ints[j];
                sum = sum > 0 ? sum : -sum;
                if (i != j && sum < min) {
                    a = ints[i];
                    b = ints[j];
                    min = sum;
                }
            }
        }
        System.out.println(a + " " + b + " " + min);
    }
}
