package com.wp.main.leetcode.medium;

/**
 * @Description 颜色分类
 * 给定一个包含红色、白色和蓝色、共n个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、1和2分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * <p>
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * <p>
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 * <p>
 * 进阶：
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * @Author admin
 * @Date 2023/8/21 15:47
 */
public class LeetCode75 {
    public static void main(String[] args) {

    }

    /**
     * 个人思路：快速排序思路，将比1大的值放在1的右侧，比1小的值放在1的左侧
     *
     * @param nums 给定数组
     */
    private static void individualExecution(int[] nums) {
        // x是最后一个0元素的索引位置，y是第一个1元素的索引位置，i是当前遍历到的元素
        // x和i从0开始，y从数组的最后一个位置开始
        int x = 0, y = nums.length - 1, i = 0;
        while (i < y) {
            if (nums[i] > 1) {
                /**1、当前元素比1大**/


            } else if (nums[i] < 1) {
                /**2、当前元素比1小**/
                // 元素不用动，x指针右移一位
                x++;
            } else {
                /**3、当前元素等于1**/
                // 不用做任何处理，当前遍历元素右移一位即可
            }
            i++;
        }
    }
}
