package com.wp.main.leetcode.easy;

/**
 * @Description 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n)的算法。
 * <p>
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * <p>
 * 示例2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * <p>
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * 提示:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums为无重复元素的升序排列数组
 * -104 <= target <= 104
 * @Author admin
 * @Date 2023/4/11 14:39
 */
public class LeetCode35 {
    public static void main(String[] args) {
        /*int[] nums = {1, 3, 5, 6};
        int target = 5;*/
        /*int[] nums = {1, 3, 5, 6};
        int target = 2;*/
        /*int[] nums = {1, 3, 5, 6};
        int target = 7;*/
        /*int[] nums = {1, 3, 5};
        int target = 4;*/
        int[] nums = {3, 5, 7, 9, 10};
        int target = 8;
        System.out.println(individualExecute(nums, target));
    }

    /**
     * 官方解答：思路大致相同，但是更简洁
     * 求平均值的方式可以注意下，因为要防止int溢出
     * 思路：求目标值的位置其实就是求第一个大于等于target值的位置
     * 那么一共有3种情况：
     * 1、left=right重合，且当前位置的值是target：此时left所在的位置就是答案。如{1,3,5}，target=3
     * 2、left=right重合，且当前位置的值不是target：此时left所在的位置就是答案。如{1,3,5}，target=2
     * 3、left>right，那么就意味着不存在target值：此时left所在的位置就是答案。如{1,3,5,7,9}，target=6
     * 所以最终就是找到left指针的位置就是答案。
     *
     * @param nums
     * @param target
     * @return
     */
    private static int standardExecute(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                l = mid - 1;
            }
        }
        return l;
    }

    /**
     * 个人思路：二分法
     *
     * @param nums   给定数组
     * @param target 目标值
     * @return
     */
    private static int individualExecute(int[] nums, int target) {
        /**
         * 1、特殊情况处理
         */
        // 如果数组为空
        if (nums.length == 0) {
            return 0;
        }
        // 比最小值还小
        if (nums[0] > target) {
            return 0;
        }
        // 比最大值还大
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        /**
         * 2、二分法逻辑
         */
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            // 指针重合但是依然不是target，则判断target应该在哪个位置
            if (left == right) {
                if (nums[middle] > target) {
                    return middle;
                } else {
                    return middle + 1;
                }
            }
            if (target < nums[middle]) {
                right = middle - 1;
            } else if (target > nums[middle]) {
                left = middle + 1;
            }
        }
        if (left > right) {
            return left;
        }
        return -1;
    }
}
