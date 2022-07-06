package com.amoscloud.newcoder.easy;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2021/3/26
 * Time: 15:03
 * Description:
 */
public class Main40 {
    public static void main(String[] args) {
        /*
        幼儿园两个班的小朋友排队时混在了一起
        每个小朋友都知道自己跟前面一个小朋友是不是同班
        请你帮忙把同班的小朋友找出来
        小朋友的编号为整数
        与前面一个小朋友同班用Y表示
        不同班用N表示
        输入描述：
        输入为空格分开的小朋友编号和是否同班标志
        比如 6/N 2/Y 3/N 4/Y
        表示一共有4位小朋友
        2和6是同班 3和2不同班 4和3同班
        小朋友总数不超过999
         0< 每个小朋友编号 <999
         不考虑输入格式错误

         输出两行
         每一行记录一班小朋友的编号  编号用空格分开
         并且
         1. 编号需要按照大小升序排列，分班记录中第一个编号小的排在第一行
         2. 如果只有一个班的小朋友 第二行为空
         3. 如果输入不符合要求输出字符串ERROR

         示例：
         输入
         1/N 2/Y 3/N 4/Y
         输出
         1 2
         3 4
         说明：2的同班标记为Y因此和1同班
              3的同班标记位N因此和1,2不同班
              4的同班标记位Y因此和3同班
         */

        Scanner in = new Scanner(System.in);
        String[] stus = in.nextLine().split(" ");
        in.close();

        try {

            TreeSet<Integer> c1 = new TreeSet<>();
            TreeSet<Integer> c2 = new TreeSet<>();

            boolean is1 = true;
            for (int i = 0; i < stus.length; i++) {
                String[] split = stus[i].split("/");
                String id = split[0];
                String same = split[1];
                if (i == 0) {
                    c1.add(Integer.parseInt(id));
                    continue;
                }
                if ("N".equals(same)) is1 = !is1;
                (is1 ? c1 : c2).add(Integer.parseInt(id));
            }

            StringBuilder b1 = new StringBuilder();
            for (Integer id : c1) b1.append(id).append(" ");

            if (c2.size() > 0) {
                StringBuilder b2 = new StringBuilder();
                for (Integer id : c2) b2.append(id).append(" ");
                if (c1.first() < c2.first()) {
                    System.out.println(b1.toString().trim());
                    System.out.println(b2.toString().trim());
                } else {
                    System.out.println(b2.toString().trim());
                    System.out.println(b1.toString().trim());
                }
            } else {
                System.out.println(b1.toString().trim());
            }

        } catch (Exception e) {
            System.out.println("ERROR");
        }

    }

}
