package com.wp.main.leetcode.medium;

/**
 * @Description 单词搜索
 * 给定一个m x n二维字符网格board和一个字符串单词word。如果word存在于网格中，返回true；否则，返回false。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * @Author admin
 * @Date 2023/8/25 10:30
 */
public class LeetCode79 {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
//        String word = "SEE";
//        String word = "ABCB";
        System.out.println(individualExecution(board, word));
    }

    /**
     * 个人思路：递归回溯。递归选择，每个格子可选的范围是相邻的格子，通过计数器n记录当前是words的第几个字符
     *
     * @param board 存储字母的二维数组
     * @param word  目标单词
     * @return 是否存在单词
     */
    private static boolean individualExecution(char[][] board, String word) {
        boolean result;
        // 当前选择的字符
        int n = 0;
        int rowNum = board.length, columnNum = board[0].length;
        for (int i = 0; i < board.length; i++) {
            char[] row = board[i];
            for (int j = 0; j < row.length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    // 进行字符的选择
                    result = recursion(board, word, n++, i, j, rowNum, columnNum);
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean recursion(char[][] board, String word, int n, int i, int j, int rowNum, int columnNum) {
        // 1、递归终止条件：遍历正常结束前找到连续字符串
        if (n > word.length() - 1) {
            return true;
        }

        // 2、记录当前字符
        char temp = board[i][j];
        // 清空字符：因为要对每个字符的相邻字符做选择，如果已经选择过了就不能再选，因此先记录后清空
        board[i][j] = '\0';

        // 3、递归逻辑
        // 上面字符是否是下一个字符
        if (i - 1 >= 0 && board[i - 1][j] != '\0' && board[i - 1][j] == word.charAt(n)) {
            if (!recursion(board, word, n++, i - 1, j, rowNum, columnNum)) {
                // 不符合word，还原
                board[i][j] = temp;
            } else {
                return true;
            }
        }
        // 下面字符是否是下一个字符
        if (i + 1 <= rowNum && board[i + 1][j] != '\0' && board[i + 1][j] == word.charAt(n)) {
            if (!recursion(board, word, n++, i + 1, j, rowNum, columnNum)) {
                // 不符合word，还原
                board[i][j] = temp;
            } else {
                return true;
            }
        }
        // 左面字符是否是下一个字符
        if (j - 1 >= 0 && board[i][j - 1] != '\0' && board[i][j - 1] == word.charAt(n)) {
            if (!recursion(board, word, n++, i, j - 1, rowNum, columnNum)) {
                // 不符合word，还原
                board[i][j] = temp;
            } else {
                return true;
            }
        }
        // 右面字符是否是下一个字符
        if (j + 1 <= columnNum && board[i][j + 1] != '\0' && board[i][j + 1] == word.charAt(n)) {
            if (!recursion(board, word, n++, i, j + 1, rowNum, columnNum)) {
                // 不符合word，还原
                board[i][j] = temp;
            } else {
                return true;
            }
        }
        // 循环结束也未找到合适的字符串
        return false;
    }
}
