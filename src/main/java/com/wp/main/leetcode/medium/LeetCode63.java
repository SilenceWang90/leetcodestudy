package com.wp.main.leetcode.medium;

/**
 * @Description 不同路径 II
 * 一个机器人位于一个m x n网格的左上角（起始点在下图中标记为 “Start”）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 示例 1：
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * <p>
 * 示例 2：
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 * <p>
 * 提示：
 * m ==obstacleGrid.length
 * n ==obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] 为 0 或 1
 * @Author admin
 * @Date 2023/7/2 10:23
 */
public class LeetCode63 {
    public static void main(String[] args) {
//        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] obstacleGrid = {{0,1},{0,0}};
        System.out.println(individualExecution(obstacleGrid));
    }

    /**
     * 个人思路：动态规划方式，记录每个坐标可达的路线数。状态转移方程为：上坐标位置的路线数+下坐标路线数。需要额外的二维数组记录每个节点的数据
     * 特殊处理：上或者左坐标有1的时候，记录为0即可，即表示不可达
     *
     * @param obstacleGrid 给定数组
     * @return 返回最终可达路线数
     */
    private static int individualExecution(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] result = new int[m][n];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (obstacleGrid[x][y] == 1) {
                    // 机器人位置赋值为0，不可达
                    result[x][y] = 0;
                } else if (x == 0 && y == 0) {
                    // 初始位置赋值为1
                    result[x][y] = 1;
                } else if (x == 0) {
                    // 上边界
                    result[x][y] = result[x][y - 1];
                } else if (y == 0) {
                    // 左边界
                    result[x][y] = result[x - 1][y];
                } else {
                    result[x][y] = result[x - 1][y] + result[x][y - 1];
                }
            }
        }
        return result[m - 1][n - 1];
    }
}
