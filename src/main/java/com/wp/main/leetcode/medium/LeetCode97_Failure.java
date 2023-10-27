package com.wp.main.leetcode.medium;

/**
 * @Description 交错字符串
 * 给定三个字符串s1、s2、s3，请你帮忙验证s3是否是由s1和s2交错组成的。
 * 两个字符串s和t交错的定义与过程如下，其中每个字符串都会被分割成若干非空子字符串：
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 注意：a + b 意味着字符串 a 和 b 连接。
 * <p>
 * 示例 1：
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：s1 = "", s2 = "", s3 = ""
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1、s2、和 s3 都由小写英文字母组成
 * @Author wangpeng
 * @Date 2023/10/25 16:46
 */
public class LeetCode97_Failure {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(individualExecution(s1, s2, s3));
    }

    /**
     * 思路：动态规划。boolean类型二维数组f[i][j]，表示s1的前i的字符串和s2的前j个字符串，能不能交错组成s3。
     *
     * @param s1
     * @param s2
     * @param s3 判断s3能否由s1和s2交错而成
     * @return
     */
    private static boolean individualExecution(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        // 如果s1+s2的长度不等于s3，肯定无法交错组成s3
        if (m + n != s3.length()) {
            return false;
        }
        /** 二维数组长度比字符串长度多1，因为要额外记录result[0][0]位置上的数据(边界数据)为true。所以要在原有长度m和n基础上额外+1 **/
        boolean[][] result = new boolean[m + 1][n + 1];
        // s3的前0个字符肯定和s1和s2前0个字符能匹配，相当于边界值确认为true
        result[0][0] = true;
        // 动态规划逻辑
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // 如果s1的第i个字符和s3的第i+j个字符相等，那么s3能否被s1和s2交错组成，取决于s1的i-1个字符串和s2的j个字符串能否组成s3的i+j-1字符串
                if (i > 0 && s1.charAt(i) == s3.charAt(i + j)) {
                    result[i][j] = result[i - 1][j];
                }
                if (j > 0 && s2.charAt(j) == s3.charAt(i + j)) {
                    result[i][j] = result[i][j - 1];
                }
            }
        }


        /** 最终的值就是s1和s2是否能交错形成s3的结果
         *  注意：数组定义长度是m+1和n+1，但是数组从坐标取值赋值的时候是从0开始的，所以result[m][n]获得的就是result二维数组第m+1个和n+1个的数字
         *  数组这个经常容易因为定义数组长度时的概念没理解透彻，所以造成理解困难或困惑
         */
        return result[m][n];
    }
}
