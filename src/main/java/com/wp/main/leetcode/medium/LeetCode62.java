package com.wp.main.leetcode.medium;

/**
 * @Description 不同路径
 * 一个机器人位于一个 m x n网格的左上角（起始点在下图中标记为 “Start”）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * <p>
 * 示例 1：
 * 输入：m = 3, n = 7
 * 输出：28
 * <p>
 * 示例 2：
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * <p>
 * 示例 3：
 * 输入：m = 7, n = 3
 * 输出：28
 * <p>
 * 示例 4：
 * 输入：m = 3, n = 3
 * 输出：6
 * <p>
 * 提示：
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 109
 * @Author wangpeng
 * @Date 2023/6/28 17:06
 */
public class LeetCode62 {
    public static void main(String[] args) {
        System.out.println(individualExecution(3, 7));
//        System.out.println(individualExecution(3, 2));
//        System.out.println(individualExecution(7, 3));
//        System.out.println(individualExecution(3, 3));
    }

    /**
     * 个人思路：动态规划/分治法。每个点记录其到达的不同路径数，每个点都只有其上面和左面的点可以到达，因此每个点只需要将其上面和左面点
     * 累计和就是到达当前点的不同路径数
     *
     * @param m
     * @param n
     * @return
     */
    private static int individualExecution(int m, int n) {
        int[][] towDimensionArray = new int[m][n];
        for (int row = 0; row < m; row++) {
            for (int column = 0; column < n; column++) {
                if (row == 0 && column == 0) {
                    // 出发点可达方式直接赋值为1
                    towDimensionArray[0][0] = 1;
                } else if (row == 0) {
                    // 边界行处理
                    towDimensionArray[row][column] = towDimensionArray[row][column - 1];
                } else if (column == 0) {
                    // 边界列处理
                    towDimensionArray[row][column] = towDimensionArray[row - 1][column];
                } else {
                    // 非边界节点，每个节点等于其上面的节点和左边的节点之和
                    towDimensionArray[row][column] = towDimensionArray[row][column - 1] + towDimensionArray[row - 1][column];
                }
            }
        }
        return towDimensionArray[m-1][n-1];
    }
}
