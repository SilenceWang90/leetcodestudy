package com.wp.main.leetcode.medium;

/**
 * MARK：
 * 1、二维数组定义：设int[][] arr = new int[3][4]，那么该二维数组的定义有2种解读方式
 * 1.1、解读一：二维数组中有3个一维数组，每个一维数组由4个元素组成。
 * 1.2、解读二：该二维数组对应一个3行4列的网格。结合解读一中的定义：
 * （1）每个一维数组为一行，第一个一维数组第一行，第二个一维数组第二行，第三个一维数组第三行，依此类推；
 * （2）每个一维数组中的元素为一列，每个一维数组中的第一个元素为第一列，每个一维数组中的第二个元素为第二列，每个一维数组中的第三个元素为第三列\
 * tips：
 * 1、二维数组的长度就是一位数组的个数，如上，arr.length=3;
 * 2、二维数组的遍历：先遍历二维数组，即查找二位数中的一维数组；然后遍历二维数组，即遍历二维数组中的元素
 *         int[][] arr = {{1, 3, 1, 6}, {1, 5, 1}, {4, 2, 1, 3}};
 *         for (int x = 0; x < arr.length; x++) {
 *             for (int y = 0; y < arr[x].length; y++) {
 *                 System.out.println(arr[x][y]);
 *             }
 *         }
 */

/**
 * @Description 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例 1：
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 示例 2：
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 * <p>
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 * @Author admin
 * @Date 2023/3/2 9:49
 */
public class LeetCode64Mark {
    public static void main(String[] args) {
        int[][] arr = {{1, 3, 1, 6}, {1, 5, 1}, {4, 2, 1, 3}};
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[x].length; y++) {
                System.out.println(arr[x][y]);
            }
        }
        /*int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(individualExecute(grid));*/
    }


    private static int individualExecute(int[][] grid) {
        int result = 0;


        return result;
    }
}
