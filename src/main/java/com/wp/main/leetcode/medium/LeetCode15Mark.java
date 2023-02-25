package com.wp.main.leetcode.medium;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * MARK：
 * 数组中查找不重复的内容，可以通过排序处理。这样在遍历数组的时候，如果当前遍历的值与前一个值相同，则直接跳过
 */

/**
 * @Description 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * <p>
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * <p>
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 * <p>
 * 提示：
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * @Author admin
 * @Date 2023/2/25 15:57
 */
public class LeetCode15Mark {
    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {0,1,1};
        int[] nums = {0,0,0};
        standardExecute(nums);
    }

    private static List<List<Integer>> standardExecute(int[] nums) {
        List<List<Integer>> result = Lists.newArrayList();
        /**
         * 1、对数组进行升序排序，排序后的数组可以很方便的解决重复组合的问题
         * */
        Arrays.sort(nums);
        /**
         * 2、对数组进行遍历，固定一个数字，其它两个数字进行组合求目标值
         */
        for (int a = 0; a < nums.length; a++) {
            // 下一个数字和前一个数字相同，就不需要遍历了，因为不需要重复的结果
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            // 初始b为左指针，c为右指针
            int b = a + 1;
            int c = nums.length - 1;
            // 当b和c重合时循环停止
            /**
             * 3、a的下一位为左指针，数组的最后一位为右指针。双指针相互移动。
             */
            while (b < c) {
                // 左指针向右移动时，如果数字和前一个相同，则移至下一位
                // b起始位置不需要判断，因为刚起步没有前一个值
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    b++;
                    continue;
                }
                // 右指针向左移动时，如果数字和前一个相同，则移至下一位
                // c起始位置不需要判断，因为刚起步没有前一个值
                if (c < nums.length - 1 && nums[c] == nums[c + 1]) {
                    c--;
                    continue;
                }
                /**
                 * 4、已知数组为升序排序，且左指针b向右移动，右指针c向做移动。所以：
                 * 4.1、如果三数之和大于0，由于是升序数组，因此想要结果为0，只能向左移动c，降低整体加和的结果。
                 * 4.2、如果三数之和小于0，由于是升序数组，因此想要结果为0，只能向右移动b，提升整体加和的结果。
                 * 4.3、如果三数之和等于0，则找到结果放入结果集中。左指针右移，右指针左移。
                 */
                if (nums[a] + nums[b] + nums[c] > 0) {
                    c--;
                } else if (nums[a] + nums[b] + nums[c] < 0) {
                    b++;
                } else {
                    List<Integer> temp = Lists.newArrayList(nums[a], nums[b], nums[c]);
                    result.add(temp);
                    b++;
                    c--;
                }
            }
        }
        System.out.println("结果为：" + result);
        return result;
    }
}
