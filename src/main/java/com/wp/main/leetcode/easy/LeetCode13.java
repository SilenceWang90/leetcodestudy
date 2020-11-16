package com.wp.main.leetcode.easy;

/**
 * @Classname LeetCode13
 * @Description 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 * <p>
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 * <p>
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *  
 * <p>
 * 提示：
 * <p>
 * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 * IC 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 * @Date 2020/11/7 19:31
 * @Created by wangpeng116
 */
public class LeetCode13 {
    public static void main(String[] args) {
        String romaNumber1 = "III";
        String romaNumber2 = "IV";
        String romaNumber3 = "IX";
        String romaNumber4 = "LVIII";
        String romaNumber5 = "MCMXCIV";
        standardExecute(romaNumber1);
        standardExecute(romaNumber2);
        standardExecute(romaNumber3);
        standardExecute(romaNumber4);
        standardExecute(romaNumber5);
    }

    /**
     * 从尾数开始，如果数字右边的数字比左边的小，则两数相加；
     * 如果右边的数字比左边的数字大，则两数相减
     *
     * @param target
     */
    private static void standardExecute(String target) {
        Integer pre;
        Integer current = romaToInteger(target.charAt(target.length() - 1));
        Integer result = current;
        for (int i = target.length() - 2; i >= 0; i--) {
            pre = romaToInteger(target.charAt(i));
            if (current.compareTo(pre) <= 0) {
                result += pre;
            } else {
                result -= pre;
            }
            current = pre;
        }
        System.out.println(result);
    }

    private static Integer romaToInteger(char roma) {
        switch (roma) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
