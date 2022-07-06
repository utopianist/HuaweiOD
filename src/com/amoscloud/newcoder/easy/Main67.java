package com.amoscloud.newcoder.easy;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2021/7/8
 * Time: 13:44
 * Description: 90
 */
public class Main67 {
    /*
题目描述：

给定一个字符串s，最多只能进行一次变换，返回变换后能得到的最小字符串（按照字典序进行比较）。
变换规则：交换字符串中任意两个不同位置的字符。
输入描述：

一串小写字母组成的字符串s
输出描述：

按照要求进行变换得到的最小字符串
备注：

s是都是小写字符组成
1<=s.length<=1000
示例

输入：

abcdef
输出：

abcdef
说明：

abcdef已经是最小字符串，不需要交换
输入：

bcdefa
输出：

acdefb
说明：
只能变换一次，

a和b进行位置交换，可以得到最小字符串
————————————————
版权声明：本文为CSDN博主「JOEL-T99」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_47243236/article/details/122741845
         */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();

        char[] chars = str.toCharArray();
        char tmp = chars[0];
        int pos = 0;
        for (int i = 1; i < chars.length; i++) {  // 只能变换一次，
            char cur = chars[i];
            if (cur <= tmp) {
                tmp = cur;
                pos = i;
            }
        }

        if (pos != 0) {
            chars[pos] = chars[0];
            chars[0] = tmp;
        }

        System.out.println(new String(chars));

    }
}
