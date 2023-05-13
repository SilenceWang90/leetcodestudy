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
     * 以当前数字为结尾的连续最大和，取决于以前一个元素为结尾的连续最大和。
     * 然后判断当前元素是加入到前面的连续子数组中还是独立
     *
     * @param nums 给定数组
     * @return 最大和
     */
    private static int individualExecute(int[] nums) {
        // 累计和和最大值设置为数组第一个元素，保证遍历逻辑一致
        int result = nums[0];
        int accumulation = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 计算当前值作为连续数组最后一个元素的最大累计和
            accumulation = Math.max(nums[i], accumulation + nums[i]);
            // 判断是否是最大值，是的话就更细
            result = Math.max(result, accumulation);
        }
        return result;
    }


    /**
     * 官方思路：分治法
     *
     * @param nums 给定数组
     * @return 最大和
     */
    /*private static int standardExecute(int[] nums) {
        // 最大子数组和
        int result = 0;
        int left = 0, right = nums.length - 1;
        int middle = (left + right) / 2;
        // 分治，将数组拆分，最后合并每个子数组的和，寻求最大的和
        recursion(left, middle, nums);
        recursion(middle, right, nums);
        return result;
    }*/

    /**
     * 递归逻辑
     *
     * @param left  左指针
     * @param right 右指针
     * @param nums  给定数组
     * @return 当前递归所能产生的最大和
     */
    /*private static int recursion(int left, int right, int[] nums) {
        // 递归终止条件
        if (left >= right) {
            return nums[right];
        }

        int middle = (left + right) / 2;
        int a = recursion(left, middle, nums);
        int b = recursion(middle, right, nums);
        // 递归后进行组合，找到区间最大值
    }*/
}
