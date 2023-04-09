package com.wp.main.leetcode.medium;

/**
 * @Description
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums在预先未知的某个下标 k（0 <= k < nums.length）上进行了旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如，[0,1,2,4,5,6,7]在下标3处经旋转后可能变为[4,5,6,7,0,1,2] 。
 * 给你旋转后的数组nums和一个整数target，如果nums中存在这个目标值target ，则返回它的下标，否则返回-1。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 * @Author admin
 * @Date 2023/4/9 14:48
 */
public class LeetCode33 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(standardExecute(nums, target));
    }

    public static int standardExecute(int[] nums, int target) {
        return 0;
    }

    public static int individualExecute(int[] nums, int target) {
        return 0;
    }
}
