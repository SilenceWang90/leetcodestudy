package com.wp.main.leetcode.medium;


/**
 * MARK：
 * 1、针对数字的每一位取值，比如十位上的数字取值就是目标数字对100求余，获得余数pop，用pop再除以10就是目标数字十位上的数字。
 * 百位上的数字取值：目标数字对1000求余，获得数字pop，用pop再除以100就是目标数字百位上的数字。
 */

/**
 * @Description 整数转罗马数字
 * 罗马数字包含以下七种字符：I，V，X，L，C，D和M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给你一个整数，将其转为罗马数字。
 * <p>
 * 示例1:
 * 输入:num = 3
 * 输出: "III"
 * <p>
 * 示例2:
 * 输入:num = 4
 * 输出: "IV"
 * <p>
 * 示例3:
 * 输入:num = 9
 * 输出: "IX"
 * <p>
 * 示例4:
 * 输入:num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * <p>
 * 示例5:
 * 输入:num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * 提示：
 * 1 <= num <= 3999
 * @Author admin
 * @Date 2023/2/24 13:53
 */
public class LeetCode12Mark {
    public static void main(String[] args) {
        standardExecute(1994);
    }

    /**
     * 个人解法：
     *
     * @param num 目标整数
     * @return 罗马数字
     */
    private static String individualExecute(int num) {
        return null;
    }

    /**
     * 官方解法：硬编码，将每个位置上的情况都列举出来，放在该位数组上的对应索引位置
     * 然后根据给定数字num进行每一位的数字获取，然后再从对应位置的数组中获取罗马数字即可
     *
     * @param num 目标整数
     * @return 罗马数字
     */
    private static String standardExecute(int num) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        StringBuffer roman = new StringBuffer();
        roman.append(thousands[num / 1000]);
        roman.append(hundreds[(num % 1000) / 100]);
        roman.append(tens[(num % 100) / 10]);
        roman.append(ones[num % 10]);
        System.out.println(roman.toString());
        return roman.toString();
    }
}
