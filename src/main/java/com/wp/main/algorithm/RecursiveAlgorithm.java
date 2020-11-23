package com.wp.main.algorithm;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Classname RecursiveAlgorithm
 * @Description 递归算法
 * 递归的三要素：
 * 1、明确递归终止条件；
 * 2、给出递归终止时的处理办法；
 * 3、提取重复的逻辑，缩小问题规模。
 * @Date 2020/11/23 15:12
 * @Created by wangpeng116
 */
public class RecursiveAlgorithm {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        int n = list.size();
        int m = 3;
        execute(list, n, m);

        //CPU和内存测试：8个标段，每个标段8个供应商。CPU拉满，内存占用2个G
        List<String> a = Lists.newArrayList();
        for (int i = 0; i <= 16777215; i++) {
            a.add(String.valueOf(i));
            System.out.println(a.size());
        }
    }

    /**
     * 实现排列组合数据(Cnm)穷举：
     * 从n个数取m个数的组合数,相当于就是用公式C(n,m) = C(n-1,m) + C(n-1,m-1)。
     * 根据该公式，每次递归会分裂为两次递归，直至m=1或m=n的情况，打印出当前组合情况。
     *
     * @param list
     * @param n：底数，共多少个数据
     * @param m：选择几个
     */
    private static void execute(List<String> list, int n, int m) {

    }
}
