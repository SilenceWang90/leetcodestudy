package com.wp.main.leetcode.medium;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Mark：模拟法，模拟顺时针的运行方式。
 * 使用了do while~~~
 */

/**
 * @Description 螺旋矩阵
 * 给你一个m行n列的矩阵matrix，请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * @Author admin
 * @Date 2023/06/03 8:14
 */
public class LeetCode54Mark {
    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},{13,14,15,16}};
        System.out.println(individualExecute(matrix));
    }

    /**
     * 个人思路：记录遍历指针特征，x轴指针，y轴指针
     * （1）右移，y++;
     * （2）左移，y--;
     * （3）下移，x++;
     * （4）上移，x--;
     * 取走的值赋值-111，因为题中定义-100 <= matrix[i][j] <= 100，只要前方要取的值是-111即视为被取走了，那么就可以进行转向操作
     *
     * @param matrix
     * @return
     */
    private static List<Integer> individualExecute(int[][] matrix) {
        List<Integer> result = Lists.newArrayList();
        // x指针能移动的最大长度为一维数组的个数，y指针能移动的最大长度为一维数组中元素的数量。
        int xLength = matrix.length, yLength = matrix[0].length;
        // 定义x轴和y轴坐标信息
        int x = 0, y = 0;
        // 只要集合中数量没达标，则循环逻辑继续
        while (result.size() < xLength * yLength) {
            // 顺时针指定移动逻辑
            // 右移
            do {
                // 取值，并将该位置的值标记为已取走
                if (matrix[x][y] != -111) {
                    result.add(matrix[x][y]);
                    matrix[x][y] = -111;
                }
                y++;
            }
            while (y < yLength && matrix[x][y] != -111);
            // 跳出循环后归位，否则接下来的数组取值就会索引溢出
            y--;
            // 下移
            do {
                // 取值，并将该位置的值标记为已取走
                if (matrix[x][y] != -111) {
                    result.add(matrix[x][y]);
                    matrix[x][y] = -111;
                }
                x++;
            }
            while (x < xLength && matrix[x][y] != -111);
            // 跳出循环后归位，否则接下来的数组取值就会索引溢出
            x--;
            // 左移
            do {
                // 取值，并将该位置的值标记为已取走
                if (matrix[x][y] != -111) {
                    result.add(matrix[x][y]);
                    matrix[x][y] = -111;
                }
                y--;
            }
            while (y >= 0 && matrix[x][y] != -111);
            // 跳出循环后归位，否则接下来的数组取值就会索引溢出
            y++;
            // 上移
            do {
                // 取值，并将该位置的值标记为已取走
                if (matrix[x][y] != -111) {
                    result.add(matrix[x][y]);
                    matrix[x][y] = -111;
                }
                x--;
            }
            while (x >= 0 && matrix[x][y] != -111);
            // 跳出循环后归位，否则接下来的数组取值就会索引溢出
            x++;
        }
        return result;
    }

}
