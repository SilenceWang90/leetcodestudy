package com.wp.main.leetcode.easy;

/**
 * @Description 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * <p>
 * 示例1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * <p>
 * 示例2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * <p>
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 * <p>
 * 提示：
 * <p>
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * @Author wangpeng
 * @Date 2023/7/4 13:35
 */
public class LeetCode66 {
    public static void main(String[] args) {
        int[] digits = {1, 2, 3};
//        int[] digits = {4, 3, 2, 1};
//        int[] digits = {0};
        System.out.println(individualExecution(digits));
    }

    private static int[] individualExecution(int[] digits) {
        // 进位
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            // 当前位置进行+1运算。加和时要和进位一起进行加法运算
            int current = digits[i] + 1 + carry;
            // 判断加和后是否存在进位，记录进位数
            carry = current % 10;
            // 当前位置赋值
            digits[i] = current / 10;
        }
        // 加和计算后进位还有值，则需要扩充数组
        if (carry != 0) {
            int length = digits.length + 1;
            int[] result = new int[length];
            result[0] = carry;
            for (int i = digits.length - 1; i >= 0; i--) {
                // 对位赋值，因为result[]比digits[]长1位，所以以digits[]为参照向result赋值时需要+1
                result[i + 1] = digits[i];
            }
            return result;
        } else {
            return digits;
        }
    }
}
