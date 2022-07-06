package com.amoscloud.newcoder.easy;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2021/5/13
 * Time: 17:44
 * Description:
 */
public class Main57 {
    public static void main(String[] args) {

/*
    给定一个字符串
    只包含大写字母
    求在包含同一字母的子串中
    长度第K长的子串
    相同字母只取最长的子串

    输入
     第一行 一个子串 1<len<=100
     只包含大写字母
     第二行为k的值

     输出
     输出连续出现次数第k多的字母的次数

     例子：
     输入
             AABAAA
             2
     输出
             1
       同一字母连续出现最多的A 3次
       第二多2次  但A出现连续3次

    输入

    AAAAHHHBBCDHHHH
    3

    输出
    2

//如果子串中只包含同一字母的子串数小于k

则输出-1
-----------------------

题目描述
给定一个字符串，只包含大写字母，求在包含同一字母的子串中，长度第 k 长的子串的长度，相同字母只取最长的那个子串。

输入描述
第一行有一个子串(1<长度<=100)，只包含大写字母。
第二行为 k的值。

输出描述
输出连续出现次数第k多的字母的次数。

示例1
输入

AAAAHHHBBCDHHHH
3

输出

2


说明
同一字母连续出现的最多的是A和H，四次；第二多的是H，3次，但是H已经存在4个连续的，故不考虑；下个最长子串是BB，所以最终答案应该输出2。

示例2
输入

AABAAA
2

输出

1


说明
同一字母连续出现的最多的是A，三次；第二多的还是A，两次，但A已经存在最大连续次数三次，故不考虑；下个最长子串是B，所以输出1。

示例3
输入

ABC
4

输出

-1


说明
只含有3个包含同一字母的子串，小于k，输出-1。

示例4
输入

ABC
2

输出

1


说明
三个子串长度均为1，所以此时k = 1，k=2，k=3这三种情况均输出1。特此说明，避免歧义。
备注：若子串中只包含同一字母的子串数小于k，则输出-1。

思路分析
相同字母只取最长的那个子串。。
输出连续出现次数第k多的字母的次数。
————————————————
版权声明：本文为CSDN博主「巨坚强」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/AOBO516/article/details/125123225
 */

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int k = in.nextInt();
        HashMap<Character, Integer> map = new HashMap<>();

        char[] chars = line.toCharArray();
        if (chars.length == 0) {
            System.out.println(-1);
            return;
        }

        char cur = chars[0];
        int count = 1;
        map.put(cur, count);

        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c == cur) count++;
            else {
                cur = c;
                count = 1;
            }
            map.put(cur, map.containsKey(cur) ?
                    map.get(cur) > count ? map.get(cur) : count :
                    count);
        }

        ArrayList<String> list = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            list.add(entry.getKey() + "-" + entry.getValue());
        }

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.split("-")[1].compareTo(o1.split("-")[1]);
            }
        });

        if (k > list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(k - 1).split("-")[1]);
        }

        in.close();

    }
}
