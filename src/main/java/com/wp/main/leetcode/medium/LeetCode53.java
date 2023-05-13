package com.wp.main.leetcode.medium;

/**
 * @Description 最大子数组和
 * 给你一个整数数组nums，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组是数组中的一个连续部分。
 * <p>
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
 * <p>
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * <p>
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * @Author admin
 * @Date 2023/5/13 8:14
 */
public class LeetCode53 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {1};
//        int[] nums = {5,4,-1,7,8};
        System.out.println(individualExecute(nums));
    }

    /**
     * 个人思路：动态规划
     * 每个当前数字可组成的最大和取决于他前面的数字的最大和，然后和自己进行加法判断哪个更大
     * 当出现某个值使得和减小，则跳过该值，且累加和置为0从下一位开始重新累计
     *
     * @param nums
     * @return
     */
    private static int individualExecute(int[] nums) {
        // 最大子数组和
        int result = 0;
        // 累计和，为了让循环逻辑一致，默认值赋值为数组的第一个元素
        int accumulattion = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            //
            if (accumulattion < accumulattion + current) {
                result = Math.max(result, accumulattion);
                accumulattion = 0;
            } else {
                accumulattion = accumulattion + current;
            }
        }
        return result;
    }
}
