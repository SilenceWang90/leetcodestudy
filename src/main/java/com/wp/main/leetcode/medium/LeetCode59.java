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
     * 1、从外层向内层循环即可，记录上、下、左、右四条边的初始位置，顺时针赋值使得每层的顺序都是：向右、向下、向左、向上。而每个方向完成后相当于都完成了四边形一条边的赋值，那么该边的"厚度"必然要-1。
     * 即从左上角开始移动，右移完成后上面的边+1、下移完成后右面的边-1、左移完成后下面的边-1、上移完成后左面的边+1。按照这种赋值思想，每一层复制后，四条边都完成了向内层嵌入的逻辑，按照此方式不断循环直至
     * 赋值完所有值即可。
     * 2、其实每条边都代表着这条边赋值时固定的一个维度，即右移的时候赋值为[top,i]，下移的时候赋值为[i,right]，左移的时候赋值为[bottom,i]，上移的时候赋值为[i,left]。
     * 即左移和右移所在一维数组不变，变化的只是数组中的位置i；上移和下移一维数组不断变化，但是每一维数组中的位置是不变的，都是i。
     * 且每一条边赋值完成后都要向内侧移动1的距离，为了下一层赋值的时候初始化好初始值！！！
     *
     * @param n
     * @return
     */
    private static int[][] individualExecution(int n) {
        int[][] result = new int[n][n];
        /**1、定义上下左右四条边所在的初始位置。*/
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        // 当前数组中要赋值的元素，也表示了已赋值的元素数量
        int num = 1;
        /**2、顺时针赋值*/
        while (num <= n * n) {
            // 1、从左向右移
            for (int i = left; i <= right; i++) {
                // 上边界赋值
                result[top][i] = num;
                // 上边界赋值完成进入下一层的上边界
                top++;
                num++;
            }
            // 2、从上向下移
            for (int i = top; i <= bottom; i++) {
                // 右边界赋值
                result[i][right] = num;
                // 右边界赋值完成进入下一层的右边界
                right--;
                num++;
            }
            // 3、从右向左移
            for (int i = right; i >= left; i--) {
                // 下边界赋值
                result[bottom][i] = num;
                // 下边界赋值完成进入下一层的下边界
                bottom--;
                num++;
            }
            // 4、从下向上移
            for (int i = bottom; i >= top; i--) {
                // 左边界赋值
                result[i][left] = num;
                // 左边界赋值完成进入下一层的左边界
                left++;
                num++;
            }
        }
        return result;
    }
}
