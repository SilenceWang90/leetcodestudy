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
//        int[] nums = {2,0,2,1,1,0};
        int[] nums = {2, 0, 1};
        individualExecution(nums);

        // 展示排序后的数组
        for (int obj : nums) {
            System.out.println(obj + " ");
        }
    }

    /**
     * 个人思路：快速排序思路，将比1大的值放在1的右侧，比1小的值放在1的左侧
     *
     * @param nums 给定数组
     */
    private static void individualExecution(int[] nums) {
        // x是最后一个0元素右侧的索引位置（即第一个1元素），y是第一个2元素左侧的索引位置（即最后一个1元素），i是当前遍历到的元素
        // x和i从0开始，y从数组的最后一个位置开始
        int x = 0, y = nums.length - 1, i = 0;
        while (i < y) {
            if (nums[i] > 1) {
                /**1、当前元素比1大**/
                // 1.1、i和当前y索引的元素互换位置
                int temp = nums[y];
                nums[y] = nums[i];
                nums[i] = temp;
                // 1.2、y指针左移
                y--;
                // 1.3、切记此时i指针不能动，因为移过来一个新的元素，下一次依旧从该元素进行判断
                // no i++;
            } else if (nums[i] < 1) {
                /**2、当前元素比1小**/
                // 2.1、i和当前x索引的元素互换位置
                int temp = nums[i];
                nums[i] = nums[x];
                nums[x] = temp;
                // 2.2、x指针右移一位
                x++;
                // 2.3、遍历元素右移
                i++;
            } else {
                /**3、当前元素等于1**/
                // 不用做任何处理，当前遍历元素右移一位即可
                i++;
            }
        }
    }
}
