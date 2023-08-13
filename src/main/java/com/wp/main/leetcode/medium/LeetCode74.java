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


    /**
     * 个人思路：二分法，需要2次二分查找：
     * 1、先通过行二分法判断target在哪一行
     * 2、然后在该行通过二分法找到具体在哪个区间。
     * 如果存在则返回true，否则返回false
     *
     * @param matrix 二维矩阵
     * @param target 要查找的目标值
     * @return 是否存在
     */
    private static boolean individualExecution(int[][] matrix, int target) {
        boolean exist = false;
        // 二维矩阵存在多少行
        int row = matrix.length;
        // 二维矩阵存在多少列
        int column = matrix[0].length;
        // 1、行二分
        int top = 0, bottom = row - 1;
        int rowNum = scanRow(top, bottom, matrix, target);
        // 2、列二分
        int[] rowTarget = matrix[rowNum];
        int left = 0;
        int right = rowTarget.length - 1;
        exist = scanColumn(left, right, rowTarget, target);
        return exist;
    }

    /**
     * 行遍历
     *
     * @param top    首指针
     * @param bottom 尾指针
     * @param matrix 给定二维矩阵
     * @param target 要查找的目标值
     * @return 返回数据所在行
     */
    private static int scanRow(int top, int bottom, int[][] matrix, int target) {
        while (top < bottom) {
            int middle = top + (bottom - top) / 2;
            if (matrix[middle][0] == target) {
                return middle;
            } else if (matrix[middle][0] < target) {
                // target大于某行首个元素，可能代表2个情况：
                // （1）target就在该行
                // （2）target不在该行，在后面的几行
                // 因此要通过如下再判断一下target是否小于下一行的首个元素，是的话意味着target就在当前行就直接返回该行即可；否则继续向下半部区间查找即可
                if (target < matrix[middle + 1][0]) {
                    return middle;
                } else {
                    top = middle + 1;
                }
            } else {
                bottom = middle - 1;
            }
        }
        // 此处返回top或者bottom都可以，因为找到数据所在行时，top会和bottom相等~
        return top;
    }

    /**
     * 列遍历
     *
     * @param left   左指针
     * @param right  右指针
     * @param array  要遍历的数组
     * @param target 目标值
     * @return
     */
    private static boolean scanColumn(int left, int right, int[] array, int target) {
        while (left <= right) {
            int middle = left + (right - left) / 2;
            // 找到该值，直接返回true
            if (array[middle] == target) {
                return true;
            } else if (array[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        // 遍历完成，仍未找到target，返回false
        return false;
    }
}
