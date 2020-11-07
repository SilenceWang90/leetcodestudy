package com.wp.main.leetcode;

/**
 * @Classname LeetCode9
 * @Description 回文数：不用字符串转
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * @Date 2020/11/7 19:31
 * @Created by wangpeng116
 */
public class LeetCode9 {
    public static void main(String[] args) {
        Integer example1 = 12344321;
        Integer example2 = 1234565432;
        Integer example3 = 234454432;
        Integer example4 = -234454432;
        Integer example5 = 0;
        Integer example6 = 123443210;
        System.out.println(execute(example1));
        System.out.println(execute(example2));
        System.out.println(execute(example3));
        System.out.println(execute(example4));
        System.out.println(execute(example5));
        System.out.println(execute(example6));
    }

    /**
     * 通过从target数字后面开始重组数字x，这样只需要遍历一半target的数字即可判断是不是回文数
     * 整数数字个数为偶数个时，直接比较target==x；
     * 整数数字个数为奇数数个时，直接比较target==x/10；
     * 注意如果尾数为0时要特殊处理
     *
     * @param target
     * @return
     */
    private static boolean execute(Integer target) {
        boolean result = false;
        //每次求余的值
        Integer pop;
        //每次去掉末尾数字的值
        Integer x = 0;
        //余数为0但是数字不为0，则直接返回false即可，因为0放在首位不计
        if (target % 10 == 0 && target != 0) {
            return false;
        }
        while (x < target) {
            pop = target % 10;
            target = target / 10;
            x = x * 10 + pop;
        }
        //1221偶数长度直接比较相等即可；12321奇数个数需要排除掉最后一位再比较相等。
        if (x.equals(target) || x / 10 == target) {
            result = true;
        }
        return result;
    }
}
