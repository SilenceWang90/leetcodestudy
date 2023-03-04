package com.wp.main.leetcode.easy;

/**
 * MARK：
 * 1、动态规划，同leetCode64
 * 2、滚动数组：我们假设将每层楼梯的走法结果存入一个数组中。由于每个走法都等于前两个结果，我们假设p和q分别为前两个结果，result为当前楼梯的结果。
 * 那么就存在这样一种赋值关系可以不断找到下一个台阶的结果：将后一个值赋值给前一个值，这样前两个值(p和q)赋值完成后，result就等于p+q。
 * （1）p = q。
 * （2）result = q。
 * （3）result = p + q。
 * 不好理解的话可以看leetcode官方答案的一个动态图。
 */

/**
 * 爬楼梯：
 * 假设你正在爬楼梯。需要 n阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * <p>
 * 示例 2：
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * <p>
 * 提示：
 * 1 <= n <= 45
 *
 * @Description
 * @Author admin
 * @Date 2023/3/3 12:03
 */
public class LeetCode70Mark {
    public static void main(String[] args) {
//        System.out.println(individualExecute(2));
//        System.out.println(individualExecute(4));
        System.out.println(individualExecute(30));
        System.out.println(individualExecute(45));

        System.out.println(standardExecute(30));
        System.out.println(standardExecute(45));
    }


    /**
     * 个人思路：动态规划：走到最后一阶台阶的方式只能从倒数第二个台阶跨2层或者从倒数第一个台阶跨1层才能到达。因此最后一层的走法取决于走到倒数第二层的走法和走到倒数第一层走法之和
     * 通过递归我可以确认每一层走法等于前两层走法之和，直到边界值1和2(0感觉概念上不太好理解，但是测试用例中有0，且等于0的时候结果为1，所以就先顺手加上了~)
     * 虽然结果正确，但是leetcode官方认为超时了......
     *
     * @param n 台阶数
     * @return 多少种走法
     */
    private static int individualExecute(int n) {
        int result;
        if (n == 1 || n == 0) {
            result = 1;
        } else if (n == 2) {
            result = 2;
        } else {
            // 从第三阶台阶开始，每层台阶的走法为：前两个台阶的走法之和。
            result = individualExecute(n - 2) + individualExecute(n - 1);
        }
        return result;
    }

    /**
     * 官方解法：滚动数组
     *
     * @param n
     * @return
     */
    private static int standardExecute(int n) {
        // 第一个值
        int p = 0;
        // 第二个值
        int q = 0;
        // 累计结果，第一阶台阶为边界值，结果为1，我们从第一阶台阶开始爬起
        int result = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = result;
            result = p + q;
        }
        return result;
    }
}
