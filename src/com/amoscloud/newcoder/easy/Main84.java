package com.amoscloud.newcoder.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2021/12/22
 * Time: 9:07
 * Description:  95%
 */
public class Main84 {
    /*
    小组中每位都有一张卡片
    卡片是6位以内的正整数
    将卡片连起来可以组成多种数字
    计算组成的最大数字

    输入描述：
      ","分割的多个正整数字符串
      不需要考虑非数字异常情况
      小组种最多25个人

     输出描述：
       最大数字字符串

     示例一
       输入
        22,221
       输出
        22221

      示例二
        输入
          4589,101,41425,9999
        输出
          9999458941425101
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nums = in.nextLine();
        in.close();

        StringBuilder builder = new StringBuilder();

        Arrays.stream(nums.split(","))
                .sorted((s1, s2) -> {
                    char[] v1 = s1.toCharArray();
                    char[] v2 = s2.toCharArray();
                    int len1 = v1.length;
                    int len2 = v2.length;

                    if (len1 == len2) {
                        return s2.compareTo(s1);     // 字符串排序
                    }

                    int min = Math.min(len1, len2);
                    for (int i = 0; i < min; i++) {  // 长度不同的，比较公有的长度，1111 和 222 就拿前三个 111 和 222 来比较
                        char c1 = v1[i];
                        char c2 = v2[i];
                        if (c1 != c2) {           // 公有长度对应的数字不相同，就按大小返回了
                            return c2 - c1;
                        }
                    }

                    if (len1 > len2) {            // 长度不同，且公有长度对应的数字相同
                        return v1[0] - v1[min];   // v1[0] 代表 s2，v1[min] 代表 s1，降序比较
                    } else {
                        return v2[min] - v2[0];   // v2[min] 代表 s2，v2[0] 代表 s1，降序比较
                    }
                })
                .forEach(builder::append);

        System.out.println(builder);

    }


    /**
     *     原文链接：https://blog.csdn.net/magi1201/article/details/114418949
     * @param args
     * @throws IOException
     */
    public static void Method2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {

            // 将输入字符串逗号分割，将分割后的数组转换为list
            String[] numArr = input.split(",");
            List<String> list = Arrays.asList(numArr);

            // 对list进行排序
            // 若字符串长度相等，则将数字值大的放前面 23和12比较，23排前面
            // 若长度不等，比较拼接值大小，拼接值大的放前面 123和23,23123值大于12323,23排123
            list.sort((next, previous) -> next.length() == previous.length() ?
                    previous.compareTo(next) : (previous + next).compareTo(next + previous));

            // 对list中字符数字进行拼接
            StringBuilder sb = new StringBuilder();
            for (String num : list) {
                sb.append(num);
            }

            System.out.println(sb);
        }
    }

}
