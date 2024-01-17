package com.wp.main.leetcode.easy;

/**
 * @Description 验证回文串
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个回文串。
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 * <p>
 * 示例 2：
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 * <p>
 * 示例 3：
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 * <p>
 * 提示：
 * 1 <= s.length <= 2 * 105
 * s 仅由可打印的 ASCII 字符组成
 * @Author wangpeng
 * @Date 2024/1/17 16:52
 */
public class LeetCode125 {
    public static void main(String[] args) {
        System.out.println(individualExecution("A man, a plan, a canal: Panama"));
        System.out.println(individualExecution("race a car"));
        System.out.println(individualExecution(" "));
    }

    /**
     * 思路：双指针法
     *
     * @param s 给定字符串
     * @return 返回结果
     */
    private static boolean individualExecution(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] str = s.toCharArray();
        while (left < right) {
            if (!Character.isLetter(str[left]) && !Character.isDigit(str[left])) {
                left++;
                continue;
            }
            if (!Character.isLetter(str[right]) && !Character.isDigit(str[right])) {
                right--;
                continue;
            }
            if (Character.toLowerCase(str[left]) != Character.toLowerCase(str[right])) {
                return false;
            }
            left++;
            right--;
        }
        // 指针相遇，则符合回文字符串特征
        return true;
    }
}
