package com.wp.main.leetcode.medium;

/**
 * @Description 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums在预先未知的某个下标 k（0 <= k < nums.length）上进行了旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标从0开始计数）。
 * 例如，[0,1,2,4,5,6,7]在下标3处经旋转后可能变为[4,5,6,7,0,1,2] 。
 * 给你旋转后的数组nums和一个整数target，如果nums中存在这个目标值target，则返回它的下标，否则返回-1。
 * 你必须设计一个时间复杂度为O(logn)的算法解决此问题。
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
        /**1、特殊场景判断**/
        int n = nums.length;
        // 1、数组为空
        if (n == 0) {
            return -1;
        }
        // 2、数组只有一个值
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        /**2、将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
         * 此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.**/
        int left = 0, right = n - 1;
        // 左右指针重合时，数组查询完成
        while (left <= right) {
            int middle = (left + right) / 2;
            // 判断当前的middle结果是否为目标值
            if (nums[middle] == target) {
                return middle;
            }
            // 1、左侧是有序数组
            if (nums[0] <= nums[middle]) {
                // 1.1、如果目标值在有序数组中，则锁定下一次查询从[0,middle-1]范围开始
                if (nums[0] <= target && target < nums[middle]) {
                    right = middle - 1;
                } else {
                    // 1.2、如果目标值在无序数组中，则锁定下一次查询从[middle+1,right]范围开始
                    left = middle + 1;
                }
            } else {
                // 2、右侧是有序数组
                // 2.1、如果目标值在有序数组中，则锁定下一次查询从[middle+1,right]范围开始
                if (nums[middle] < target && target <= nums[n - 1]) {
                    left = middle + 1;
                } else {
                    // 2.2、如果目标值在无序数组中，则锁定下一次查询从[left,middle-1]范围开始
                    right = middle - 1;
                }
            }
        }
        return -1;
    }
}
