package com.wp.main.leetcode.medium;

/**
 * @Description 两数相除
 * 给你两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和取余运算。
 * 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345将被截断为8，-2.7335将被截断至-2。
 * 返回被除数dividend除以除数divisor得到的商。
 * 注意：假设我们的环境只能存储32位有符号整数，其数值范围是 [−231, 231− 1] 。本题中，如果商严格大于231−1，则返回231−1；
 * 如果商严格小于-231，则返回-231。
 * <p>
 * 示例1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = 3.33333..，向零截断后得到3。
 * <p>
 * 示例2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = -2.33333..，向零截断后得到 -2 。
 * <p>
 * 提示：
 * -231 <= dividend, divisor <= 231 - 1
 * divisor != 0
 * @Author admin
 * @Date 2023/3/30 13:55
 */
public class LeetCode29 {
    public static void main(String[] args) {

    }

    /**
     * 根据大神的逻辑写的代码：
     * 1、对特殊情况的判断，如被除数为0、除数为0、越界处理等
     * 2、符号处理：把符号摘出来，相当于对正整数做除法处理
     * 3、a / b = c，相当于a = b*c，也就是在找除数翻多少倍能得到a，根据此逻辑进行递归计算
     *
     * @param dividend
     * @param divisor
     * @return
     */
    private static int individualExecute(int dividend, int divisor) {
        /**
         * 1、特殊情况处理
         */
        // 被除数为0，直接返回0
        if (dividend == 0) {
            return 0;
        }
        // 除数为1，直接返回被除数
        if (divisor == 1) {
            return dividend;
        }
        // 除数为-1，小心越界(int的范围是：[2的-31次幂,2的31次幂-1]，所以最小值的相反数会导致越界，要做特殊处理)~
        if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE) {
                return -dividend;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        /**
         * 2、符号处理
         */


        /**
         *
         */


    }

}
