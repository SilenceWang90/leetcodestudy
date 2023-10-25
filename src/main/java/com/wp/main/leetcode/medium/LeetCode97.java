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
public class LeetCode97 {
    public static void main(String[] args) {

    }

    private static boolean individualExecution(String s1, String s2, String s3) {
        boolean result = false;
        for (int i = 0; i < s3.length(); i++) {
            char current = s3.charAt(i);
        }

        return result;
    }
}
