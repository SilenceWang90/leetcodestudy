package com.wp.main.leetcode.medium;

/**
 * @Description 单词搜索
 * 给定一个m x n二维字符网格board和一个字符串单词word。如果word存在于网格中，返回true；否则，返回false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * @Author admin
 * @Date 2023/8/25 10:30
 */
public class LeetCode79 {
    public static void main(String[] args) {

    }

    /**
     * 个人思路：
     *
     * @param board 存储字母的二维数组
     * @param word  目标单词
     * @return 是否存在单词
     */
    private static boolean individualExecution(char[][] board, String word) {
        // 当前选择的字符
        int n = 0;
        for (int i = 0; i < board.length; i++) {
            char[] row = board[i];
            for (int j = 0; j < row.length; j++) {
                if (board[i][j] == word.charAt(n)) {
                    //
                    n++;
                }
            }
        }


        return true;
    }
}
