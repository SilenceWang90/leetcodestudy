package com.wp.main.leetcode.easy;

/**
 * @Description 二进制求和
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * <p>
 * 示例1：
 * 输入:a = "11", b = "1"
 * 输出："100"
 * <p>
 * 示例2：
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 * <p>
 * 提示：
 * <p>
 * 1 <= a.length, b.length <= 104
 * a 和 b 仅由字符 '0' 或 '1' 组成
 * 字符串如果不是 "0" ，就不含前导零
 * @Author wangpeng
 * @Date 2023/7/4 14:02
 */
public class LeetCode67 {
    public static void main(String[] args) {
        String a = "";
        String b = "";
//        String a = "";
//        String b = "";
        System.out.println(addBinary(a, b));
    }

    private static String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int aLength = a.length();
        int bLength = b.length();
        int n = 1;
        // 进位
        int carry = 0;
        while (n <= Math.min(aLength, bLength)) {
            // 从后向前获取a和b同位置的字符
            int aCurrent = a.charAt(aLength - n);
            int bCurrent = b.charAt(bLength - n);
            // 求和
            int sum = aCurrent + bCurrent + carry;
            // 计算加和后的数值
            int current = sum % 2;
            // 计算进位数值
            carry = sum / 2;
            // 记录每一位的计算结果
            stringBuilder.append(current);
            // 更新到下一位的计算
            n++;
        }
        String left = "";
        // 同位置循环后判断a和b哪个字符串有剩余，剩余的字符串进行后续的计算
        if (aLength > n) {
            // 字符串a有剩余
            left = a.substring(0, aLength - n);
        } else {
            // 字符串b有剩余
            left = b.substring(0, bLength - n);
        }
        /// 剩余字符串计算
        for (int i = left.length() - 1; i >= 0; i--) {
            int current = left.charAt(i);
            int sum = current + carry;
            stringBuilder.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            stringBuilder.append(carry);
        }
        // 返回结果
        return stringBuilder.reverse().toString();
    }
}
