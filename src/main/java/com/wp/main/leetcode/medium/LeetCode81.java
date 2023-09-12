package com.wp.main.leetcode.medium;

/**
 * @Description 搜索旋转排序数组 II
 * 已知存在一个按非降序排列的整数数组nums，数组中的值不必互不相同。
 * 在传递给函数之前，nums在预先未知的某个下标k（0<=k<nums.length）上进行了旋转，使数组变为[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标从0开始计数）。
 * 例如，[0,1,2,4,4,4,5,6,6,7]在下标5处经旋转后可能变为[4,5,6,6,7,0,1,2,4,4]。
 * 给你旋转后的数组nums和一个整数target，请你编写一个函数来判断给定的目标值是否存在于数组中。如果nums中存在这个目标值 target，则返回true，否则返回false。
 * <p>
 * 你必须尽可能减少整个操作步骤。
 * 示例 1：
 * 输入：nums = [2,5,6,0,0,1,2], target = 0
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：nums = [2,5,6,0,0,1,2], target = 3
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -104 <= target <= 104
 * <p>
 * <p>
 * 进阶：
 * 这是 搜索旋转排序数组 的延伸题目，本题中的nums可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 * @Author admin
 * @Date 2023/9/12 9:34
 */
public class LeetCode81 {
    public static void main(String[] args) {
        /*int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        System.out.println(individualExecution(nums, target));*/

        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 3;
        System.out.println(individualExecution(nums, target));
    }

    /**
     * 个人思路：二分法
     * 找到2个数组中有序的那个，如果目标数字有序数组中则在有序数组中继续进行二分法；如果不在有序数组中则在无序数组，则在无序数组中继续使用二分法
     * 通过递归完成二分法逻辑，直到左指针>=右指针
     *
     * @param nums
     * @param target
     * @return
     */
    private static boolean individualExecution(int[] nums, int target) {

        return recursion(nums, target, 0, nums.length - 1);
    }

    /**
     * 递归逻辑
     *
     * @param nums   给定数组
     * @param target 目标数值
     * @param left   左指针
     * @param right  右指针
     */
    private static boolean recursion(int[] nums, int target, int left, int right) {
        /**1、递归终止条件**/
        if (left > right) {
            // 查找完所有数字也未找到目标值
            return false;
        }
        // middle索引即目标数字，则直接返回
        int middle = left + (right - left) / 2;
        if (nums[middle] == target) {
            return true;
        }
        /**2、递归逻辑**/
        if (nums[left] <= nums[middle]) {
            /** 2.1、左侧数组有序**/
            if (target < nums[middle]) {
                // target在有序数组区间
                right = middle - 1;
            } else {
                // target不在有序数组区间
                left = middle + 1;
            }
        } else {
            /** 2.2、右侧数组有序**/
            if (target > nums[middle]) {
                // target在有序数组区间
                left = middle + 1;
            } else {
                // target不在有序数组区间
                right = middle - 1;
            }
        }
        /**2.3、锁定区间后，继续递归查找目标值是否存在**/
        return recursion(nums, target, left, right);
    }
}
