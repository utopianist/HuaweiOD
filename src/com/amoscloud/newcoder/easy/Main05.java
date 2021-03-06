package com.amoscloud.newcoder.easy;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2020/11/7
 * Time: 14:01
 * Description:
 */
public class Main05 {
  /*
  题目描述：
为了充分发挥Gpu算力，
需要尽可能多的将任务交给GPU执行，
现在有一个任务数组，
数组元素表示在这1s内新增的任务个数，
且每秒都有新增任务，
假设GPU最多一次执行n个任务，
一次执行耗时1s，
在保证Gpu不空闲的情况下，最少需要多长时间执行完成。

输入描述
第一个参数为gpu最多执行的任务个数
取值范围1~10000
第二个参数为任务数组的长度
取值范围1~10000
第三个参数为任务数组
数字范围1~10000

输出描述
执行完所有任务需要多少秒

示例一
输入

3
5
1 2 3 4 5
COPY
输出

6
COPY
说明
一次最多执行3个任务，最少耗时6s

示例二
输入

4
5
5 4 1 1 1
COPY
输出

5
COPY
说明
一次最多执行4个任务，最少耗时5s
   */
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      int n = scanner.nextInt();
      int len = scanner.nextInt();
      int[] jobCount = new int[len];
      for (int i = 0; i < len; i++) {
        jobCount[i] = scanner.nextInt();
      }
      solution(n, jobCount);
    }
  }

  private static void solution(int n, int[] jobCount) {
    int time = 0;
    int remaining = 0;
    for (int count : jobCount) {
      if (count + remaining > n) {
        remaining = count + remaining - n;
      } else {
        remaining = 0;
      }
      time++;
    }
    time += remaining / n;
    if (remaining % n > 0) {
      time++;
    }
    System.out.println(time);
  }
}
