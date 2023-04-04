package com.wp.main.leetcode.medium;

import java.util.Arrays;

/**
 * @Description 下一个排列
 * 整数数组的一个 排列就是将其所有成员以序列或线性顺序排列。
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的下一个排列就是在这个有序容器中排在它后面的那个排列。
 * 如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2]。类似地，arr = [2,3,1] 的下一个排列是 [3,1,2]。而 arr = [3,2,1]的下一个排列是[1,2,3]，因为 [3,2,1]不存在一个字典序更大的排列。
 * 给你一个整数数组nums，找出nums的下一个排列。必须原地修改，只允许使用额外常数空间。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * <p>
 * 示例 3：
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 * @Author admin
 * @Date 2023/4/4 13:55
 */
public class LeetCode31 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
//        int[] nums = {3,2,1};
//        int[] nums = {1, 1, 5};
//        individualExecute(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 算法推导
     * 如何得到这样的排列顺序？这是本文的重点。我们可以这样来分析：
     * <p>
     * 我们希望下一个数 比当前数大，这样才满足 “下一个排列” 的定义。因此只需要 将后面的「大数」与前面的「小数」交换，就能得到一个更大的数。比如123456，将5和6交换就能得到一个更大的数123465。
     * 我们还希望下一个数 增加的幅度尽可能的小，这样才满足“下一个排列与当前排列紧邻“的要求。为了满足这个要求，我们需要：
     * 在 尽可能靠右的低位 进行交换，需要从后向前查找
     * 将一个尽可能小的「大数」与前面的「小数」交换。比如 123465，下一个排列应该把5和4交换而不是把6和4交换
     * 将「大数」换到前面后，需要将「大数」后面的所有数 重置为升序，升序排列就是最小的排列。以 123465 为例：首先按照上一步，交换 5和4，得到123564；然后需要将5之后的数重置为升序，得到123546。
     * 显然123546比123564更小，123546就是123465的下一个排列
     * 以上就是求 “下一个排列” 的分析过程。
     *
     * @param nums
     */
    private static void standardExecute(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                Arrays.sort(nums, i, len);
                for (int j = i; j < len; j++) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
        return;
    }

    /**
     * 个人思路：未通过
     * 1、从右侧遍历数组，判断相邻2个数字的大小：
     * 1.1、如果后面的数字b比前面的数字a大：记录这两个数字
     * （1）继续遍历数组，如果存在后面的数字小于等于前面的数字或数组已遍历完成，则终止循环，交换第一次记录的两个数字的位置
     * （2）继续遍历数组，如果均是后面的数字比前面的数字大，则交换最后两个数字的位置
     * 1.2、如果后面的数字都比前一个数字小，则交换第一和第二个数字的位置，用插入排序实现
     */
    @Deprecated
    private static void individualExecute(int[] nums) {
        Integer a = null;
        Integer b = null;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                if (i == 1) {
                    int temp = nums[nums.length - 1];
                    nums[nums.length - 1] = nums[nums.length - 2];
                    nums[nums.length - 2] = temp;
                    return;
                }
                a = i - 1;
                b = i;
                continue;
            }
            if (nums[i] <= nums[i - 1] && a != null && b != null) {
                int temp = nums[b];
                nums[b] = nums[a];
                nums[a] = temp;
                return;
            }

        }
        // 数组是倒序排列，使用插入排序
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
