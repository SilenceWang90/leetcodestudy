package com.wp.main.leetcode.easy;

/**
 * @Description x的平方根
 * 给你一个非负整数 x ，计算并返回x的算术平方根 。
 * 由于返回类型是整数，结果只保留整数部分，小数部分将被舍去。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如pow(x, 0.5) 或者 x ** 0.5 。
 * <p>
 * 示例 1：
 * 输入：x = 4
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 提示：
 * 0 <= x <= 231 - 1
 * @Author wangpeng
 * @Date 2023/7/4 15:13
 */
public class LeetCode69 {
    public static void main(String[] args) {
        System.out.println(individualExecution(4));
        System.out.println(individualExecution(8));
    }

    /**
     * 思路：递归，二分法
     * 1、每次取当前值的1/2，然后进行平方计算，如果比当前值大，则再取左侧1/2，否则取右侧1/2。
     * 2、如果平方计算等于当前值，则返回结果；如果平方值和前一次结果一样，也返回，意味着已经找到趋近于x的结果，
     *
     * @param x
     * @return
     */
    private static int individualExecution(int x) {
        // 递归，初始区间为[0,x]
        return recursion(0, x, x, -1);
    }

    /**
     * 递归逻辑
     * @param left 左边界
     * @param right 右边界
     * @param x 目标结果
     * @param prev 上一次平方的结果，用于比对是否得到了无限趋近结果的值
     * @return 平凡根的结果
     */
    private static int recursion(int left, int right, int x, int prev) {
        // 找到中间值(此逻辑计算平均值可避免溢出问题)
        int middle = left + (right - left) / 2;
        // 计算平方值
        int multuplicationResult = middle * middle;
        // 递归终止条件：如果当前的平方值等于上一次，则找到了无限趋近结果的值
        if (multuplicationResult == prev) {
            return left;
        }
        // 二分法逻辑
        if (multuplicationResult > x) {
            // 如果平方比目标值x大，那么就在左侧区间寻找结果
            return recursion(left, middle, x, multuplicationResult);
        } else if (multuplicationResult < x) {
            // 如果平方比目标值x小，那么就在右侧区间寻找结果
            return recursion(middle, right, x, multuplicationResult);
        } else {
            // 如果middle*middle=x，则得到最终结果
            return middle;
        }
    }
}
