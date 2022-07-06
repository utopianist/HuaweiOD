package com.amoscloud.newcoder.easy;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2021/3/26
 * Time: 14:26
 * Description:
 */
public class Main39 {
    public static void main(String[] args) {
        /*
            有一个数列A[n]
            从A[0]开始每一项都是一个数字
            数列中A[n+1]都是A[n]的描述
            其中A[0]=1
            规则如下
            A[0]:1
            A[1]:11 含义其中A[0]=1是1个1 即11
            表示A[0]从左到右连续出现了1次1
            A[2]:21 含义其中A[1]=11是2个1 即21
            表示A[1]从左到右连续出现了2次1
            A[3]:1211 含义其中A[2]从左到右是由一个2和一个1组成 即1211
            表示A[2]从左到右连续出现了一次2又连续出现了一次1
            A[4]:111221  含义A[3]=1211 从左到右是由一个1和一个2两个1 即111221
            表示A[3]从左到右连续出现了一次1又连续出现了一次2又连续出现了2次1

             输出第n项的结果
             0<= n <=59
             输入描述：
             数列第n项   0<= n <=59
             4
             输出描述
             数列内容
             111221
         */
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        in.close();

        StringBuilder next;
        String content = "1";

        if (n == 0) {
            System.out.println(content);
            return;
        }
        for (int i = 1; i <= n; i++) {
            next = new StringBuilder();

            char[] chars = content.toCharArray();
            char last = chars[0];
            int count = 1;
            for (int j = 1; j < chars.length; j++) {
                if (chars[j] == last) count++;
                else {
                    next.append(count).append(last);
                    count = 1;
                    last = chars[j];
                }
            }
            next.append(count).append(last);
            content = next.toString();
        }

        System.out.println(content);

    }
}
