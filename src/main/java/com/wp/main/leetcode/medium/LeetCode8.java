package com.wp.main.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname LeetCode8
 * @Description 字符串转换整数 (atoi)
 * 请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * <p>
 * 函数myAtoi(string s) 的算法如下：
 * <p>
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231, 231− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 * <p>
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 * <p>
 * 示例1：
 * <p>
 * 输入：s = "42"
 * 输出：42
 * 解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
 * 第 1 步："42"（当前没有读入字符，因为没有前导空格）
 * ^
 * 第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 * ^
 * 第 3 步："42"（读入 "42"）
 * ^
 * 解析得到整数 42 。
 * 由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。
 * 示例2：
 * <p>
 * 输入：s = "   -42"
 * 输出：-42
 * 解释：
 * 第 1 步："   -42"（读入前导空格，但忽视掉）
 * ^
 * 第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
 * ^
 * 第 3 步："   -42"（读入 "42"）
 * ^
 * 解析得到整数 -42 。
 * 由于 "-42" 在范围 [-231, 231 - 1] 内，最终结果为 -42 。
 * 示例3：
 * <p>
 * 输入：s = "4193 with words"
 * 输出：4193
 * 解释：
 * 第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
 * ^
 * 第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 * ^
 * 第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
 * ^
 * 解析得到整数 4193 。
 * 由于 "4193" 在范围 [-231, 231 - 1] 内，最终结果为 4193 。
 * @Date 2023/02/20 14:32
 * @Created by wangpeng116
 */
public class LeetCode8 {
    public static void main(String[] args) {
        String s = "4234";
//        String s = "-4234";
//        String s = "+4234-";
//        String s = "  -4234";
//        String s = "  4234 happy";
//        String s = "  +0 123";
//        String s = "2147483646";
//        String s = "  +  413";
        individualExecute(s);
    }

    /**
     * 官方思路：状态机
     *
     * @param str 给定字符串
     * @return 拼接结果
     */
    private static int standardExecute(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }

    /**
     * 1、while遍历字符串，终止条件为超过的长度。从字符串的第一位开始读取，如果是空格则忽略，如果是"+"或"-"则记录到flag中。flag=1或flag=-1，用于最终数字的正负转换
     * 2、最终数字记为result，result记为0，读到数字m后result赋值为result*10+m，不断遍历字符串，数字不断被读取
     * 3、判断数字是否会超出整数范围，如果超出则直接终止循环，当前数字即为结果。
     * 4、判断是否遍历到了字符串，如果是的话则终止循环，当前数字即为结果。
     *
     * @param s 给定字符串
     * @return 拼接结果
     */
    private static int individualExecute(String s) {
        int result = 0;
        // 正负号标志位
        int flag = 0;
        // 判断是否已经开始进行数字转换
        boolean startNum = false;
        for (int i = 0; i < s.length(); i++) {
            // 忽略空格
            if (s.charAt(i) == ' ' && !startNum) {
                continue;
            } else if (s.charAt(i) == ' ' && startNum) {
                // 空格出现在非起始位置，终止遍历，返回结果
                break;
            }
            // 正负号判断，注意字符串中可能出现多次"+"，"-"，只有数字前面的正负号决定正负值
            if (flag == 0 && s.charAt(i) == '-') {
                flag = -1;
                // 记录已经开始数字转换，便于前面判断进行转换后依然出现其他字符的情况
                startNum = true;
                continue;
            } else if (flag == 0 && s.charAt(i) == '+') {
                flag = 1;
                // 记录已经开始数字转换，便于前面判断进行转换后依然出现其他字符的情况
                startNum = true;
                continue;
            }
            // 数字转换过程中遇到字符则直接终止
            if (!Character.isDigit(s.charAt(i))) {
                break;
            }
            // 遇到数字后正负号标志位依然为0，则该字符为正值
            if (flag == 0) {
                flag = 1;
            }
            // 读取数字字符，进行数字转换处理
            // 此方法比较笨重，也比较容易想到：int temp = Integer.parseInt(String.valueOf(s.charAt(i)));
            // 简易且巧妙的方法：由于'0'-'9'的ASCII码为 48-57，且顺序一致，因而char数字之间的差值等于数字之间的差值，所以就让char字符与'0'进行减法运算即可得出结果~
            int temp = s.charAt(i) - '0';
            // 记录已经开始数字转换，便于前面判断进行转换后依然出现其他字符的情况
            startNum = true;
            // 判断是否越界 2147483647
            if (flag > 0 && (Integer.MAX_VALUE / 10 < result || Integer.MAX_VALUE / 10 == result && temp > 7)) {
                // 正数判断是否越界，如果越界则直接返回结果
                result = Integer.MAX_VALUE;
                break;
            }
            if (flag < 0 && (Integer.MIN_VALUE / 10 > result || Integer.MIN_VALUE / 10 == result && temp > 8)) {
                // 负数判断是否越界，如果越界则直接返回结果
                result = Integer.MIN_VALUE;
                break;
            }
            result = result * 10 + temp * flag;
        }
        System.out.println("转换结果为：" + result);
        return result;
    }

}

/**
 * 官方解答，定义的一个内部类
 */
class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}