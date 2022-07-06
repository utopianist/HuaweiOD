package com.amoscloud.newcoder.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2021/4/1
 * Time: 15:26
 * Description:
 */
public class Main41 {

    static TreeSet<String> set = new TreeSet<>();

    public static void main(String[] args) {
    /*
    给定参数n 从1到n会有n个整数 1，2，3，...n
    这n个数字共有n!种排列 按大小顺序升序列出所有排列情况
    并一一标记
    当n=3时，所有排列如下
    "123","132","213","231","312","321"
    给定n和k 返回第n个排列

    输入描述
    第一行为n
    第二行为k
    n的范围是 1~9
    k的范围是 1~n!

    输出描述
    输出排列第k位置的数字

    示例一：
    输入
    3
    3
    输出
    213

    示例二:
    输入
    2
    2
    输出
    21
     */
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int k = Integer.parseInt(in.nextLine());
        in.close();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        perm(arr, 0, n - 1);
        String res = new ArrayList<>(set).get(k - 1);
        System.out.println(res);

    }

    public static void perm(Integer[] array, int start, int end) {

        if (start == end) {
            String num = Arrays.toString(array).replaceAll("\\W+", "");
            set.add(num);
        } else {
            for (int i = start; i <= end; i++) {
                swap(array, start, i);
                perm(array, start + 1, end);
                swap(array, start, i);
            }
        }
    }

    public static void swap(Integer[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
