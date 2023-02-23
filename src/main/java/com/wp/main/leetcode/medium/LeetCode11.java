package com.wp.main.leetcode.medium;

/**
 * @Description 盛最多水的容器
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 * <p>
 * 输入：height = [1,1]
 * 输出：1
 * @Date 2023/02/23 11:33:00
 * @Created by wangpeng
 */
public class LeetCode11 {

    public static void main(String[] args) {
//        int[] target = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] target = new int[]{1,1};
        individualExecute(target);
    }

    /**
     * 思路：
     * 1、遍历数组，按序将当前索引与下一位索引之间组成的面积进行乘积计算，计算结果即二者的面积(储水量)
     * 2、每个索引与右侧所有的线进行计算，并不断比较最大值，最终最大值就是期望的结果。
     *
     * @param target 目标参数
     * @return 最大水量
     */
    private static int individualExecute(int[] target) {
        int result = 0;
        // 因为储水需要2条线，因此最后一条线不需要进行遍历
        for (int i = 0; i < target.length - 1; i++) {
            // 当前线的高度
            int height = target[i];
            // 遍历右侧线，计算当前线与其他线可组成的面积，并记录最大值
            for (int j = i + 1; j < target.length; j++) {
                // 当前计算的面积
                int currentResult;
                if (target[j] > height) {
                    currentResult = height * (j - i);
                } else {
                    currentResult = target[j] * (j - i);
                }
                // 记录较大的面积
                result = Math.max(currentResult, result);
            }

        }
        System.out.println("最大面积为："+result);
        return result;
    }
}
