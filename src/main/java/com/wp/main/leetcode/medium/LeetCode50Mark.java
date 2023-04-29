package com.wp.main.leetcode.medium;

/**
 * 递归、分治法
 */

/**
 * @Description Pow(x, n)
 * <p>
 * 实现pow(x, n)，即计算x的整数n次幂函数（即，x的n次幂）。
 * <p>
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * <p>
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * <p>
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * 提示：
 * <p>
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * n是一个整数
 * -104 <= xn <= 104
 * @Author admin
 * @Date 2023/4/29 9:27
 */
public class LeetCode50Mark {
    public static void main(String[] args) {
        /*double x = 2.00000;
        int n = 10;*/
        /*double x = 2.10000;
        int n = 3;*/
        /*double x = 2.00000;
        int n = -2;*/
        /*double x = -2.00000;
        int n = 2;*/
        double x = -2.00000;
        int n = -2;
        /*double x = -1.00000;
        int n = -2147483648;*/
        System.out.println(standardExecute(x, n));
//        System.out.println(individualExecute(x, n));
    }

    /**
     * 官方解法：分治法。x的n次方 = x的n/2次方 * x的n/2次方，因此我们在递归中不断找到“x的n/2次方(设为y)”的结果，然后将其平方计算即可，即y*y。
     * 但要注意n可能为奇数无法整除，如5/2=2，那么y*y就是x的平方*x的平方，就是x的4次方，因此在求得y的时候，y*y之后还得乘以一下x。
     * 由此，只需要判断当前的n的奇偶性，如果是奇数则在y*y的时候多乘以一下x，否则只需要得到y*y即可
     * 1、x的n次方等于x的n/2次方的平方，x的n/2次方等于x的n/4次方，如此递推。可在logn时间复杂度内解决此问题
     * 2、x的4次方等于x的2次方的2次方；x的5次方等于x的2次方的2次方再乘以x。所以针对n的奇偶性，要判断当前的平方结果是否要多乘以一次底数x。
     *
     * @param x
     * @param n
     * @return
     */
    public static double standardExecute(double x, int n) {
        long N = n;
        if (N >= 0) {
            return quickMul(x, N);
        } else {
            // n为负时，相当于1/x的n次幂。因此处理方式就是将n转为正数即-N，然后等到结果后用1除一下即可
            return 1.0 / quickMul(x, -N);
        }
    }

    public static double quickMul(double x, long N) {
        // 递归终止条件：当指数N为0时返回1，任何数的0次幂都是1。
        if (N == 0) {
            return 1.0;
        }
        // 递归逻辑：即分治逻辑，当前数为其根号下结果的平方。
        // 通过递归不断查找其根号下的值
        double y = quickMul(x, N / 2);
        // 找到根号下的值后根据幂指数的奇偶性判断是否需要额外乘一下底数
        return N % 2 == 0 ? y * y : y * y * x;
    }


    /**
     * 个人思路：正常求解
     *
     * @param x 目标数
     * @param n 指数
     * @return 结果
     */
    @Deprecated
    private static double individualExecute(double x, int n) {
        int mark = 1;
        double result;
        // 特殊处理：如果底数为1，则直接返回即可
        if (x == 1.0 || x == -1.0) {
            return x;
        }
        // 如果幂指数为极值的情况下，返回0
        if (n == Integer.MIN_VALUE) {
            return 0.0;
        }
        // 1、符号判断，用于判断用乘法还是除法
        int sign;
        if (n > 0) {
            sign = 1;
            result = x;
        } else if (n < 0) {
            sign = -1;
            n = -n;
            // 幂指数为负数时，如果底数也为负，则数字先转为正，符号特殊处理
            if (x < 0) {
                mark = -1;
                x = -x;
            }
            result = 1 / x;
        } else {
            // 任何数的0次幂结果都为1
            return 1;
        }
        // 2、计算逻辑：指数为正数则累乘，指数为负则累除
        while (n > 1) {
            if (sign > 0) {
                result = result * x;
            } else {
                result = result * 1 / x;
            }
            n--;
        }
        return result * mark;
    }
}
