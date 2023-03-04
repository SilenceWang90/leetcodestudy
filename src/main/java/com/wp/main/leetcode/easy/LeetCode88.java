package com.wp.main.leetcode.easy;

/**
 * @Description 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
 * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * <p>
 * 示例 2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * <p>
 * 示例 3：
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 * <p>
 * <p>
 * 提示：
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 * @Author admin
 * @Date 2023/3/4 10:20
 */
public class LeetCode88 {
    public static void main(String[] args) {
        /*int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;*/

        /*int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {};
        int n = 0;*/

        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;

        individualExecute(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }

    /**
     * 个人思路：从后(有元素的位置)往前遍历数组，因为如果从前往后的话，涉及移动数组；如果从后往前的话，由于nums1非元素位置都是0，可以直接赋值~
     *
     * @param nums1 数组1
     * @param m     数组1中元素的个数
     * @param nums2 数组2
     * @param n     数组2中元素的个数
     */
    private static void individualExecute(int[] nums1, int m, int[] nums2, int n) {
        // nums2数组没有元素，不需要合并，直接返回即可
        if (n == 0) {
            return;
        }
        // 赋值索引，从数组1的最后一个位置开始
        int index = nums1.length - 1;
        // 从后向前遍历2个数组，只要有数组没有遍历完就继续遍历
        while (m >= 1 || n >= 1) {
            if (m >= 1 && n >= 1) {
                // num1和nums2中，谁的元素大谁就放在后面
                if (nums1[m - 1] >= nums2[n - 1]) {
                    nums1[index] = nums1[m - 1];
                    // 数组一索引前移
                    m--;
                } else {
                    nums1[index] = nums2[n - 1];
                    // 数组二索引前移
                    n--;
                }
            } else if (m < 1) {
                // nums1数组已经遍历完只剩nums2数组，那么直接将nums2[]数组中的剩余元素依次放入nums1数组中即可
                nums1[index] = nums2[n - 1];
                n--;
            } else {
                // nums2数组已经遍历完只剩nums1数组，那么直接结束，nums1[]数组中的剩余元素都在指定位置中
                return;
            }
            // 赋值索引向前移动
            index--;
        }
    }
}
