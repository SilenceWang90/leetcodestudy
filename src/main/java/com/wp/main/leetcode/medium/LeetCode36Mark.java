package com.wp.main.leetcode.medium;

/**
 * 哈希表：用hash表存储已遍历过得内容，当hash的key值范围有限且确定时，hash表经常也可以由数组代替
 */

/**
 * @Description 有效的数独
 * 请你判断一个9 x 9的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * <p>
 * 注意：
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用'.'表示。
 * @Author admin
 * @Date 2023/4/13 11:41
 */
public class LeetCode36Mark {
    public static void main(String[] args) {
        /*char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};*/
        char[][] board = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(individualExecute(board));
    }

    /**
     * 思路：
     * 1、遍历二维数组，并记录每一行、每一列、以及每一个小九宫格的数字出现的次数
     * 1.1、用二维数组记录，设二维数组的x轴表示第几行/列/小九宫格，y轴表示数字，这样就形成了每一个数字在某行或者某列出现的次数
     * 1.2、每次记录后判断该记录的数字是否大于1，如果大于一直接返回false，否则遍历结束后返回true。
     * 1.3、其中小九宫格的索引规则为：y/3+(x/3)*3。拿第一行的3个小九宫格为例，y[0,2]是第一个九宫格，y[3,5]是第二个九宫格，y[6,8]是第三个九宫格。因此y/3即可得该行九宫格的序号。
     * 但一共有三行，第二行从4开始，第三行从7开始。也就是在原有序号的基础上加上3的倍数即可，因此(x/3)*3就符合该要求，所以(x/3)*3+y/3就是小九宫格的序号索引
     *
     * @param board
     * @return
     */
    private static boolean individualExecute(char[][] board) {
        /**1、定义记录每行、每列、每个小九宫格出现数字的次数，
         * 以下二维数组中第一个维度就是记录行、列、小九宫格的索引，列就是对应要记录的数字，二维数组的值就是出现的次数**/
        // 按行记录，因为数字范围是0-9，所以第二个维度的最大索引要声明到10
        int[][] xAxis = new int[9][10];
        // 按列记录，因为数字范围是0-9，所以第二个维度的最大索引要声明到10
        int[][] yAxis = new int[9][10];
        // 按小九宫格记录，因为数字范围是0-9，所以第二个维度的最大索引要声明到10
        int[][] block = new int[9][10];
        /**2、遍历所有的数值，记录数值的个数，并判断该数值出现的次数**/
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Character.isDigit(board[i][j])) {
                    int num = board[i][j] - '0';
                    xAxis[i][num]++;
                    yAxis[j][num]++;
                    block[j / 3 + (i / 3) * 3][num]++;
                    if (xAxis[i][num] > 1 || yAxis[j][num] > 1 || block[j / 3 + (i / 3) * 3][num] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
