package com.wp.main.leetcode.medium;

/**
 * 1、字符转数字，只需要用字符减去'0'即可，字符相减用的是字符对应的ASCII码与'0'进行减法。ASCII码中'0'-'9'是连续的数字，因此字符转数字只需要用字符减去'0'，刚好是对应的数字的值
 * 2、字符和数字转其他字符，用字符'a'加上目标字符和字符'a'的差值并强转为char类型即可获得，如(char)('a'+2)，输出的结果为字符c。
 * 2、字符加法中处理进位问题：数字加法的进位可以用当前数字乘以10即可，字符的话可以通过StringBuilder进行字符串拼接，从个位拼接到最高位，然后通过reverse()方法倒置后就是最终的结果
 * 3、字符乘法中从乘数十位数开始时，计算的结果最低位就是十位，因此为了保证初始位数就是十位，需要补0,0的个数就是该位索引和字符串长度的差值
 */

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
public class LeetCode43Mark {
    public static void main(String[] args) {
//        System.out.println(strAdd("0", "123"));
        System.out.println(individualExecute("123", "456"));
        System.out.println(individualExecute("9133", "0"));
        System.out.println(individualExecute("9133", "1"));
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
        // 当有一个数字为0时，不需要计算，直接返回结果
        if (num1.length() == 1 && "0".equals(num1) || num2.length() == 1 && "0".equals(num2)) {
            return "0";
        }
        String result = "0";
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
                int current = (m * n + carry) % 10;
                // 进位数
                carry = (m * n + carry) / 10;
                temp.append(current);
            }
            // 乘法计算完成后进位不为空，则将进位补入到结果中
            if (carry != 0) {
                temp.append(carry);
            }
            String str = temp.reverse().toString();
            result = strAdd(str, result);
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
