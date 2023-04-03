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
     * 3、a / b = c，相当于a = b*c，也就是在找除数翻多少倍能得到a，而翻倍计算又可以使用加法来实现，因此根据此逻辑进行递归计算
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
        /** int转long，这样即使商有溢出我们也可以通过用商去比较int的最值判断出来然后返回题干要求的结果 **/
        long a = dividend;
        long b = divisor;
        /**
         * 2、符号处理：记录符号，并将除数和被除数都转为正数
         */
        int sign = 1;
        if (a > 0 && b < 0 || a < 0 && b > 0) {
            sign = -1;
        }
        a = a < 0 ? -a : a;
        b = b < 0 ? -b : b;
        /**
         * 3、通过递归计算商
         */
        long result = recursion(a, b);
        /** 4、结果返回 **/
        if (sign > 0) {
            // 正数：越界处理
//            result = result > Integer.MAX_VALUE ? Integer.MAX_VALUE : result;
            return (int) result;
        } else {
            // 负数：不可能越界~，直接返回相反数即可
            return (int) -result;
        }

    }

    /**
     * 递归求解
     *
     * @param a 被除数
     * @param b 除数
     * @return 商
     */
    private static long recursion(long a, long b) {
        // 递归终止条件，被除数小于除数，则商为0
        // 递归过程不断减小a的值，当a小到比b还小递归就可以结束了~
        if (a < b) {
            return 0;
        }
        // 翻倍的个数，对该结果进行累计，当递归结束时，该结果就是a/b的商
        long result = 1;
        long multiple = b;
        while ((multiple + multiple) <= a) {
            result = result + result;
            multiple = multiple + multiple;
        }
        return result + recursion(a - multiple, b);
    }
}
