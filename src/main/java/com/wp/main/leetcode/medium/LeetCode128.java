package com.wp.main.leetcode.medium;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * @Description 最长连续序列
 * 给定一个未排序的整数数组nums，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n)的算法解决此问题。
 * <p>
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * @Author admin
 * @Date 2024/1/21 15:33
 */
public class LeetCode128 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{100, 4, 200, 1, 3, 2};
        int[] nums2 = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(individualExecution(nums1));
        System.out.println(individualExecution(nums2));
    }

    /**
     * 通过hashset记录每一个数字，遍历nums的时候去匹配当前数字的下一个数字是否存在，如果存在则累计数字长度
     *
     * @param nums
     * @return
     */
    private static int individualExecution(int[] nums) {
        /** 1、通过hashset去重nums数组**/
        Set<Integer> sets = Sets.newLinkedHashSet();
        for (int obj : nums) {
            sets.add(obj);
        }
        // 记录最长的长度
        int result = 0;
        /** 2、遍历nums数组，查找最长连续序列**/
        for (int obj : nums) {
            if (!sets.contains(obj - 1)) {
                // 记录当前的长度
                int currentResult = 1;
                int n = 1;
                while (sets.contains(obj + n)) {
                    currentResult++;
                    n++;
                }
                result = Math.max(currentResult, result);
            }
        }
        return result;
    }
}
