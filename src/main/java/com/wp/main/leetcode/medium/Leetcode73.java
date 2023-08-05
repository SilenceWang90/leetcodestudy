package com.wp.main.leetcode.medium;

import com.google.common.collect.Sets;

import java.util.Set;

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

    /**
     * 官方解法：用二维矩阵的第一行[0][j]和第一列[i][0]记录对应行和列是否存在0，这样可以不用额外空间
     *
     * @param matrix
     */
    private static void standardExecution(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        /** 1、遍历首行和首列，用于记录首行和首列哪些位置存在0。因为要用首行的所有元素和首列的所有元素记录其对应的行和列是否存在0，那么首行和首列
         * 的元素会被覆盖，对首行和首列处理的时候就无法确认是否存在0，因此先预处理首行和首列，记录存在0的位置 **/
        boolean flagCol0 = false, flagRow0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
            }
        }
        /** 2、遍历除首行和首列外的元素[i][j]，如果存在0，则记录到首行对应列的位置即[0][y]以及首列对应的位置[x][0] **/
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        /** 3、遍历除首行和首列外的元素，如果首行或首列对应位置即[0][y]或[x][0]存在0，那么此位置就要赋值为0，否则不需要处理 **/
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        /** 4、首行首列如果存在0，则直接将首行和首列置为0 **/
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    /**
     * 个人思路：
     * 1、遍历矩阵，如果遇到0则记录0所在的行和列
     * 2、用2个set，一个记录行rowSet，一个记录列columnSet。使用set也是方便去重，一行或一列出现多个0只需记录一次即可。
     * 3、遍历矩阵，给标记的行和列赋值为0。判断行和列是否存在于rowSet或columnSet，存在的话直接赋值为0。
     *
     * @param matrix
     */
    private static void individualExecution(int[][] matrix) {
        // 1、创建set用于记录出现0的行和列
        Set<Integer> rowSet = Sets.newHashSet();
        Set<Integer> columnSet = Sets.newHashSet();
        // 2、遍历矩阵，记录出现0的行和列
        for (int x = 0; x < matrix.length; x++) {
            int[] row = matrix[x];
            for (int y = 0; y < row.length; y++) {
                if (matrix[x][y] == 0) {
                    rowSet.add(x);
                    columnSet.add(y);
                }
            }
        }
        // 3、遍历矩阵，给出现0的行和列赋值为0
        for (int x = 0; x < matrix.length; x++) {
            int[] row = matrix[x];
            for (int y = 0; y < row.length; y++) {
                if (rowSet.contains(x) || columnSet.contains(y)) {
                    matrix[x][y] = 0;
                }
            }
        }

    }
}
