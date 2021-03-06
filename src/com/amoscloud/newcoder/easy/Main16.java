package com.amoscloud.newcoder.easy;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.concurrent.BrokenBarrierException;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2020/11/30
 * Time: 12:42
 * Description:
 */
public class Main16 {
    public static void main(String[] args) {

        /*
        单词接龙的规则是
        可用于接龙的单词 首字母必须要与前一个单词的尾字母相同
        当存在多个首字母相同的单词时，取长度最长的单词
        如果长度也相等，则取字典序最小的单词
        已经参与接龙的单词不能重复使用
        现给定一组全部由小写字母组成的单词数组
        并指定其中一个单词为起始单词
        进行单词接龙
        请输出最长的单词串
        单词串是单词拼接而成的中间没有空格

        输入描述
        输入第一行为一个非负整数
        表示起始单词在数组中的索引k
        0<=k<N
        输入的第二行为非负整数N
        接下来的N行分别表示单词数组中的单词

        输出描述，
        输出一个字符串表示最终拼接的单词串

        示例
        0
        6
        word
        dd
        da
        dc
        dword
        d

        输出
        worddwordda
        说明 先确定起始单词word 在接dword
        剩余dd da dc 则取da

       示例2
        4
        6
        word
        dd
        da
        dc
        dword
        d

        输出
        dwordda

        单词个数1<N<20
        单个单词的长度  1~30

         */
        Scanner in = new Scanner(System.in);

        int k = Integer.parseInt(in.nextLine());
        int N = Integer.parseInt(in.nextLine());
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(in.nextLine());
        }

        StringBuilder builder = new StringBuilder();
        String head = list.get(k);
        builder.append(head);
        list.remove(k);

        String tail = head.substring(head.length() - 1);

        while (true) {
            TreeSet<String> set = new TreeSet<>();

            for (int i = 0; i < list.size(); i++) {
                String word = list.get(i);
                if (word.startsWith(tail)) {
                    set.add(word);
                }
            }
            if (set.size() == 0) break;
            String first = set.pollFirst();
            int len = first.length();
            String aim = "";
            for (String s : set) {
                if (s.length() > len) {
                    len = s.length();
                    aim = s;
                }
            }
            String into = len != first.length() ? aim : first;
            tail = into.substring(into.length() - 1);
            builder.append(into);
            list.remove(into);
        }
        System.out.println(builder.toString());

        in.close();
    }
}
