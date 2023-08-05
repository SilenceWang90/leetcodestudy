package com.wp.main.leetcode.medium;

/**
 * @Description 矩阵置零
 * 给定一个m x n的矩阵，如果一个元素为0，则将其所在行和列的所有元素都设为0。请使用原地算法。
 * 示例 1：
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * <p>
 * 示例 2：
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 * <p>
 * 进阶：
 * 一个直观的解决方案是使用O(mn)的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用O(m + n)的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 * @Author admin
 * @Date 2023/8/5 8:49
 */
public class Leetcode73 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
//        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        individualExecution(matrix);
    }

    private static void individualExecution(int[][] matrix) {
        for (int x = 0; x < matrix.length; x++) {
            int[] row = matrix[x];
            for (int y = 0; y < row.length; y++) {

            }

        }
    }


}
