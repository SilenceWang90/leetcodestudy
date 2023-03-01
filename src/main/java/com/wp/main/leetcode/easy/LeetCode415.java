package com.wp.main.leetcode.easy;

/**
 * @Description 字符串加法运算
 * @Author admin
 * @Date 2023/3/1 14:58
 */
public class LeetCode415 {
    public static void main(String[] args) {
        System.out.println(individualExecute("9", "99"));
    }

    /**
     * 字符串加法运算
     *
     * @param num1 数字字符1
     * @param num2 数字字符2
     * @return
     */
    private static String individualExecute(String num1, String num2) {
        int m = num1.length() - 1;
        int n = num2.length() - 1;
        // 加和结果
        StringBuilder s = new StringBuilder();
        // 进位
        int carry = 0;
        while (m >= 0 || n >= 0) {
            // 字符串str的字符
            int a;
            // 字符串result的字符
            int b;
            // 字符串加和逻辑
            if (m >= 0 && n >= 0) {
                // 2个字符串均不越界，则正常取值
                a = num1.charAt(m) - '0';
                b = num2.charAt(n) - '0';
            } else if (n < 0) {
                // 如果字符串result越界，那么字符串result的字符b赋值为0
                a = num1.charAt(m) - '0';
                b = 0;
            } else {
                // 如果字符串str越界，那么字符串str的字符a赋值为0
                a = 0;
                b = num2.charAt(n) - '0';
            }
            // 字符加和，对10取余获得当前字符
            s.append((a + b + carry) % 10);
            // 记录进位数
            carry = (a + b + carry) / 10;
            // 处理下一位字符
            m--;
            n--;
        }
        // 加和计算完成后，如果进位数还有值，则继续补充
        s = carry > 0 ? s.append(carry) : s;
        return s.reverse().toString();
    }
}
