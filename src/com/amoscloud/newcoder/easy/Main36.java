package com.amoscloud.newcoder.easy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2021/3/13
 * Time: 14:44
 * Description:
 */
public class Main36 {
    public static void main(String[] args) {
        /*
        用数组代表每个人的能力
        一个比赛活动要求 参赛团队的最低能力值为N
        每个团队可以由一人或者两人组成
        且一个人只能参加一个团队
        计算出最多可以派出多少只符合要求的队伍

        输入描述
        5
        3 1 5 7 9
        8
        第一行代表总人数，范围  1~500000
        第二行数组代表每个人的能力
           数组大小范围 1~500000
           元素取值范围 1~500000
        第三行数值为团队要求的最低能力值
         1~500000

         输出描述
         3
         最多可以派出的团队数量

         示例一
         输入
         5
         3 1 5 7 9
         8

         输出
         3

         说明 3、5组成一队   1、7一队  9自己一队  输出3

         7
         3 1 5 7 9 2 6
         8

        3
        1 1 9
        8

          */

        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] nums = in.nextLine().split(" ");
        int base = Integer.parseInt(in.nextLine());
        in.close();

        Integer[] list = Arrays.stream(nums)
                .map(Integer::parseInt)
                .filter(x -> x < base)
                .sorted()
                .toArray(Integer[]::new);

        int count = nums.length - list.length;

        int i = 0, j = list.length - 1;
        while (i < j) {
            if (list[i] + list[j] >= base) {
                count++;
                i++;
                j--;
            } else i++;
        }
        System.out.println(count);
    }
}
