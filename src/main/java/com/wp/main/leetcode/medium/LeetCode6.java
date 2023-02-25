package com.wp.main.leetcode.medium;

/**
 * @Classname LeetCode6
 * @Description N字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * @Date 2023/02/20 14:32
 * @Created by wangpeng116
 */
public class LeetCode6 {
    public static void main(String[] args) {
        String target = "PAYPALISHIRING";
        int numRows = 3;
        /*String target = "PAYPALISHIRING";
        int numRows = 4;*/
        /*String target = "ABC";
        int numRows = 4;*/
        /*String target = "A";
        int numRows = 1;*/
        individualExecute(target, numRows);
        standardExecute(target, numRows);
    }

    /**
     * 官方解法：思路一致，都是创建一个二维数组，找到列的周期规律计算存在的列数
     * @param s
     * @param numRows
     * @return
     */
    private static String standardExecute(String s, int numRows) {
        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        int t = r * 2 - 2;
        int c = (n + t - 1) / t * (r - 1);
        char[][] mat = new char[r][c];
        for (int i = 0, x = 0, y = 0; i < n; ++i) {
            mat[x][y] = s.charAt(i);
            if (i % t < r - 1) {
                ++x; // 向下移动
            } else {
                --x;
                ++y; // 向右上移动
            }
        }
        StringBuffer ans = new StringBuffer();
        for (char[] row : mat) {
            for (char ch : row) {
                if (ch != 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }

    /**
     * 个人思路：
     * 1、创建二维数组，向二维数组中的指定位置放入字符。二维数组的行数已知是rows，列colomns的计算方式是：字符串长度/(rows+rows-2)。
     * 说明：
     * （1）因为N的拼接方式是'|'、'\'、'|'，因此列的计算其实就是计算'|'和'\'的组合有多少个。'|'和'\'一共可放置的字符数量为rows+(rows-2)，'\'可放置(rows-2)个字符，根据规律可知。
     * 切记'\'的两端不包括'|'中的位置，'\'中都是只有单个字符的列。
     * （2）以上计算后，最后剩余的字符串长度(字符串长度%(rows+rows-2))我们再计算需要几列即可。计算方式就是用剩余字符串长度先对rows除法，为0代表再增加一列即可放满剩余的所有字符；如果为1就再
     * 用剩余字符串长度对rows求余，余几就再加几列，当然别忘了结果再加1列，因为之前除以rows的时候还有一列可放满~
     * 经过以上计算二维数组的长宽都计算完成
     * 2、对二维数组进行循环，第一层for是列，第二层for是行。根据规律我们可以确认：
     * 2.1、第一层for
     * 3、
     *
     * @param target，要被拆分的字符串
     * @param rows            指定行数
     * @return 返回拆分结果
     */
    private static String individualExecute(String target, int rows) {
        StringBuffer result = new StringBuffer();
        /** 1、创建二维数组**/
        // 二维数组列的数量为column
        int columns = 0;
        /** 1.1、计算二维数组需要多少列**/
        // 确认拼接N的'|'和'\'的字符数量。存在一种特殊情况，当只有一行的时候其实不存在'|'和'\'的拼接，只'|'和'\'只视为'|'即可，且是1行
        int jointChars = rows == 1 ? 1 : rows + (rows - 2);
        // 计算字符串中'|'和'\'共有多少组
        int countJointChars = target.length() / jointChars;
        // 计算一组'|'和'\'一共需要多少列。存在一种特殊情况，当只有一行的时候有多少个字符就有多少列
        int countJointCharsColums = rows == 1 ? target.length() : 1 + (rows - 2);
        // 计算'|'和'\'组合之外剩余的字符串长度
        int leftCountJointChars = target.length() % jointChars;
        // 计算剩余的长度需要多少列
        int extraColumn = 0;
        // 当有剩余字符串时
        if (leftCountJointChars > 0) {
            if (leftCountJointChars / rows == 0) {
                //商为0表示再加一列即可放下剩余的字符串
                extraColumn = 1;
            } else {
                //商不为0的话就为1，表示1列放不满，还得额外再加几列，额外的几列为剩余字符串长度对rows的求余。
                extraColumn = 1 + leftCountJointChars % rows;
            }
        }
        // 二维数组所需要的列数
        columns = countJointChars * countJointCharsColums + extraColumn;
        /** 1.2、构建二维数组**/
        char[][] doubleDimension = new char[rows][columns];
        /** 2、遍历数组，在相应位置放入字符**/
        // 未放入数组的当前字符，所在的索引位置。每当二维数组放入一个字符后，n就+1。
        int n = 0;
        // 先遍历列y，然后遍历行x
        for (int y = 0; y < columns; y++) {
            // 对该列的性质做判断，确认该列是要放满还是在指定位置放入字符
            int t = y % (rows == 1 ? 1 : rows - 1);
            for (int x = 0; x < rows && n < target.length(); x++) {
                if (t == 0) {
                    // t为0则表示该列要放满元素
                    doubleDimension[x][y] = target.charAt(n);
                    // 放入字符后n要递增到下一个字符所在的位置
                    n++;
                } else {
                    // 当t不等于0时，该列不需要放满元素，只需要在特定位置放入元素即可。按照N字排序规则，放入到二维数组中该列的第rows - t - 1行即可
                    doubleDimension[rows - t - 1][y] = target.charAt(n);
                    // 放入字符后n要递增到下一个字符所在的位置
                    n++;
                    // 放入元素后不需要循环直接退出即可
                    break;
                }
            }
        }
        /** 3、遍历数组，按行拼接字符串并输出结果*/
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                if (doubleDimension[x][y] != '\0') {
                    result.append(doubleDimension[x][y]);
                }
            }
        }
        System.out.println("变形结果为：" + result.toString().trim());
        return result.toString();
    }
}
