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
//        System.out.println(individualExecution(8));
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
        return recursion(0, x, x);
    }

    private static int recursion(int left, int right, int x) {
        // 找到中间值(此逻辑计算平均值可避免溢出问题)
        int middle = left + (right - left) / 2;
        if (middle * middle > x) {
            return recursion(left, middle, x);
        } else if (middle * middle < x) {
            return recursion(middle, right, x);
        } else {
            // 如果middle*middle=x，则得到结果
            return middle;
        }
    }
}
