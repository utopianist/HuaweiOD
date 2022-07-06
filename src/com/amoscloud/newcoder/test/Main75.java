package com.amoscloud.newcoder.test;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2021/10/27
 * Time: 17:11
 * Description:
 */
public class Main75 {
  /*
  输入一串字符串
  字符串长度不超过100
  查找字符串中相同字符连续出现的最大次数

  输入描述
    输入只有一行，包含一个长度不超过100的字符串

  输出描述
    输出只有一行，输出相同字符串连续出现的最大次数

   说明：
     输出

   示例1：
     输入
hello

     输出
       2

    示例2：
      输入
       word
      输出
       1

     示例3：
      输入
        aaabbc
       输出
        3

    字符串区分大小写
   */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        scanner.close();

        int max = 1;
        for (int i = 0; i < chars.length; i++) {
            int tmp = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    tmp++;
                }
            }
            if (tmp > max) {
                max = tmp;
            }
        }

        System.out.println(max);

    }

}
