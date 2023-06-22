package com.wp.main.leetcode.medium;

/**
 * @Description 螺旋矩阵 II
 * 给你一个正整数n，生成一个包含1到n2所有元素，且元素按顺时针顺序螺旋排列的n x n正方形矩阵matrix。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 * <p>
 * 提示：
 * 1 <= n <= 20
 * @Author admin
 * @Date 2023/6/19 13:20
 */
public class LeetCode59 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(individualExecution(n));
    }

    /**
     * 个人思路：参考标准答案，按层模拟顺时针运行操作
     * 从外层向内层循环即可，记录上、下、左、右四条边的初始位置，顺时针赋值使得每层的顺序都是：向右、向下、向左、向上。而每个方向完成后相当于都完成了四边形一条边的赋值，那么该边的"厚度"必然要-1。
     * 即从左上角开始移动，右移完成后上面的边+1、下移完成后右面的边-1、左移完成后下面的边-1、上移完成后左面的边+1。按照这种赋值思想，每一层复制后，四条边都完成了向内层嵌入的逻辑，按照此方式不断循环直至
     * 赋值完所有值即可。
     * @param n
     * @return
     */
    private static int[][] individualExecution(int n) {
        int[][] result = new int[n][n];
        for (int x = 0; x < n; x++) {

        }
        return result;
    }
}
