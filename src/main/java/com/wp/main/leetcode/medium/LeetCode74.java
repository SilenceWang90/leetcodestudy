package com.wp.main.leetcode.medium;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description 搜索二维矩阵
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * （1）每行中的整数从左到右按非递减顺序排列。
 * （2）每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数target，如果target在矩阵中，返回true；否则，返回false。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 * @Author admin
 * @Date 2023/8/13 9:04
 */
@Slf4j
public class LeetCode74 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        /*int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 13;*/
        System.out.println(individualExecution(matrix, target));
    }


    private static boolean individualExecution(int[][] matrix, int target) {
        boolean exist = false;

        return exist;
    }
}
