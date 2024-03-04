package com.wp.main.leetcode.easy;

/**
 * @Description
 * @Author admin
 * @Date 2024/1/20 0:19
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
