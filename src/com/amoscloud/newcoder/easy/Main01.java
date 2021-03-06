package com.amoscloud.newcoder.easy;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2020/12/15
 * Time: 22:54
 * Description:
 *
 */
public class Main01 {
  /*
  题目描述：
如果三个正整数A、B、C ,A²+B²=C²则为勾股数
如果ABC之间两两互质，即A与B，A与C，B与C均互质没有公约数，
则称其为勾股数元组。
请求出给定n~m范围内所有的勾股数元组

输入描述
起始范围
1 < n < 10000
n < m < 10000

输出描述
ABC保证A<B<C
输出格式A B C
多组勾股数元组，按照A B C升序的排序方式输出。
若给定范围内，找不到勾股数元组时，输出Na。

示例一
输入

1
20
COPY
输出

3 4 5
5 12 13
8 15 17
COPY
示例二
输入

5
10
COPY
输出

Na
   */
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      int n = scanner.nextInt();
      int m = scanner.nextInt();
      solution(n, m);
    }
  }

  private static void solution(int n, int m) {
    int count = 0;
    for (int a = n; a < m - 1; a++) {
      for (int b = a + 1; b < m; b++) {
        for (int c = b + 1; c < m + 1; c++) {
          if (relativelyPrime(a, b) &&
              relativelyPrime(b, c) &&
              relativelyPrime(a, c) &&
              a * a + b * b == c * c) {
            count++;
            System.out.printf("%d %d %d\n", a, b, c);
          }
        }
      }
    }
    if (count == 0) {
      System.out.println("Na");
    }
  }

  private static boolean relativelyPrime(int x, int y) {
    int min = Math.min(x, y);
    double sqrt = Math.sqrt(min);
    for (int i = 2; i < sqrt; i++) {
      if (x % i == 0 && y % i == 0) {
        return false;
      }
    }
    return true;
  }
}
