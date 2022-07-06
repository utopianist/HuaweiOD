package com.amoscloud.newcoder.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2021/2/25
 * Time: 16:13
 * Description:
 */
public class Main24 {
    /*
    身高从低到高
    身高相同体重从轻到重
    体重相同维持原来顺序
    输入
    4
    100 100 120 130
    40 30 60 50
    输出：
    2 1 3 4
    输入
    3
    90 110 90
    45 60 45
    输出
    1 3 2
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] h = sc.nextLine().split(" ");
        String[] w = sc.nextLine().split(" ");
        sc.close();
        int[][] ints = new int[n][3];
        for (int i = 0; i < n; i++) {
            ints[i][0] = i + 1;
            ints[i][1] = Integer.parseInt(h[i]);
            ints[i][2] = Integer.parseInt(w[i]);
        }
        Arrays.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                //身高
                if (arr1[1] == arr2[1]) return arr1[2] - arr2[2];
                else return arr1[1] - arr2[1];
            }
        });
        for (int[] anInt : ints) {
            System.out.print(anInt[0] + " ");
        }
    }
}
