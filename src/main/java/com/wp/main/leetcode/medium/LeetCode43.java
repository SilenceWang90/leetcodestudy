package com.wp.main.leetcode.medium;

/**
 * @Description 字符串相乘
 * 给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * <p>
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * <p>
 * 示例2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * <p>
 * 提示：
 * 1 <= num1.length, num2.length <= 200
 * num1和 num2只能由数字组成。
 * num1和 num2都不包含任何前导零，除了数字0本身。
 * @Author admin
 * @Date 2023/2/28 21:40
 */
public class LeetCode43 {
    public static void main(String[] args) {
        /*char a = '2';
        char b = '6';
        int c = (a - '0') * (b - '0');
        System.out.println(c);*/
        String a = "12";
        System.out.println(a.charAt(-1));
//        System.out.println(individualExecute("8", "123"));
    }

    /**
     * 个人思路：竖式计算。num2 * num1，num2是被乘数，num1是乘数。
     * 1、从乘数的第一位(字符串的最后一位)与被乘数每一位(从最后一位起)相乘，将当前位(乘法结果的余数)拼接到StringBuilder中。然后StringBuilder进行reverser()即可获得当前乘数位与被乘数的乘积结果
     * 2、补0：根据乘法竖式计算的规则，从乘数第二位开始开始，也就是从十位数开始，要在乘法计算的基础上不断*10。对于字符串就是用0进行补位，补位之后再拼接1的结果，这样对字符串reverse()之后就获得了正确的结果。
     * 3、字符串相加
     *
     * @param num1 乘数
     * @param num2 被乘数
     * @return
     */
    private static String individualExecute(String num1, String num2) {
        String result = "";
        for (int i = num1.length() - 1; i >= 0; i--) {
            int m = num1.charAt(i) - '0';
            // 用于拼接当前结果的字符串
            StringBuilder temp = new StringBuilder();
            // 当乘数从第二位开始与被乘数进行计算时，需要用0补位
            int z = i;
            // 需要0的个数等于当前位所在索引和最大索引的差值
            // 所以对当前索引进行递增，如果不等于最大索引，则不断加0；
            while (z < num1.length() - 1) {
                temp.append('0');
                z++;
            }
            // 进位
            int carry = 0;
            // 乘法计算
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n = num2.charAt(j) - '0';
                // 当前位
                int current = m * n % 10 + carry;
                // 进位数
                carry = m * n / 10;
                temp.append(current);
            }
            String str = temp.reverse().toString();
            strAdd(str, result);
        }

        return result;
    }

    /**
     * 字符串加法运算
     *
     * @param str
     * @param result
     * @return
     */
    private static String strAdd(String str, String result) {
        int m = str.length() - 1;
        int n = result.length() - 1;
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
                a = str.charAt(m) - '0';
                b = result.charAt(n) - '0';
            } else if (n < 0) {
                // 如果字符串result越界，那么字符串result的字符b赋值为0
                a = str.charAt(m) - '0';
                b = 0;
            } else {
                // 如果字符串str越界，那么字符串str的字符a赋值为0
                a = 0;
                b = result.charAt(n) - '0';
            }
            // 字符加和，对10取余获得当前字符
            s.append((a + b) % 10 + carry);
            // 记录进位数
            carry = (a + b) / 10;
            m--;
            n--;
        }
        // 加和计算完成后，如果进位数还有值，则继续补充
        s = carry > 0 ? s.append(carry) : s;
        return s.reverse().toString();
    }
}
