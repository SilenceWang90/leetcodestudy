package com.wp.main.leetcode.medium;

/**
 * @Description 旋转图像
 * 给定一个n×n的二维矩阵matrix表示一个图像。请你将图像顺时针旋转90度。
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * <p>
 * 示例 2：
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * <p>
 * 提示：
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 * @Author admin
 * @Date 2023/4/27 10:01
 */
public class LeetCode48 {
    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        individualExecute(matrix);
    }

    /**
     * 个人思路：x为行，y为列
     * 1、旋转90度即行列转置，同一行转成同一列，同一列转成同一行
     * 2、按行处理：
     * 2.1、同一行转到同一列，列的值为：y=3-x
     * 2.2、同一行按列遍历的时候x自增：x=++x
     * 3、元素置换：增加辅助数组进行转置
     *
     * @param matrix 目标矩阵
     */
    private static void individualExecute(int[][] matrix) {
        // 矩阵维度转成数组的长度，便于数组元素进行转置的时候行与列的变换
        int n = matrix.length;
        // 新增辅助矩阵，协助存储移位后的数据
        int[][] matrixNew = new int[n][n];
        // 遍历二维数组，获取每一个维度的数组信息
        for (int x = 0; x < matrix.length; x++) {
            // 获取一维数组
            int[] xArray = matrix[x];
            // 遍历一维数组，获取数组中的每一个元素
            for (int y = 0; y < xArray.length; y++) {
                int current = matrix[x][y];
                matrixNew[y][n - x - 1] = current;
            }
        }
        for (int x = 0; x < matrixNew.length; x++) {
            int temp[] = matrixNew[x];
            for (int y = 0; y < temp.length; y++) {
                System.out.print(temp[y] + " ");
            }
            System.out.println("");
        }
    }
}
