package com.wp.main.leetcode.medium;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Description 螺旋矩阵
 * 给你一个m行n列的矩阵matrix，请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 * @Author admin
 * @Date 2023/06/03 8:14
 */
public class LeetCode54 {
    public static void main(String[] args) {

    }

    /**
     * 个人思路：记录遍历指针特征，x轴指针，y轴指针
     * （1）x向右移动到边界则下移
     * （2）x向左移动到边界则上移
     * （3）y向下移动到边界则静止不动
     * （4）y向上移动到边界则静止不动
     * @param matrix
     * @return
     */
    private static List<Integer> individualExecute(int[][] matrix) {
        List<Integer> result = Lists.newArrayList();


        return result;
    }

}
