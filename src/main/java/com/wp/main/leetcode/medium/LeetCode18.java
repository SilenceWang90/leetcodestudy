package com.wp.main.leetcode.medium;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * @Description 四数之和
 * 给你一个由n个整数组成的数组nums，和一个目标值target请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d< n
 * a、b、c和d互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * <p>
 * 示例 2：
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * @Author admin
 * @Date 2023/3/19 12:59
 */
public class LeetCode18 {
    public static void main(String[] args) {
        /*int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;*/
        int[] nums = {2, 2, 2, 2, 2};
        int target = 8;
        List<List<Integer>> result = individualExecute(nums, target);
        System.out.println(result);
    }

    /**
     * 思路：同15题“三数之和”
     * 1、先排序，便于解决重复问题
     * 2、通过双指针减少一层时间复杂度。如果穷举的话是O(n四次方)，可减少到O(n三次方)
     *
     * @param nums   给定的数组
     * @param target 目标和
     * @return 结果集
     */
    private static List<List<Integer>> individualExecute(int[] nums, int target) {
        Arrays.sort(nums);
        // 结果
        List<List<Integer>> result = Lists.newArrayList();
        // 选择第一个数：一共需要4个数，因此组合中的第一个数的索引值最大只能是数组长度的倒数第四个
        for (int x = 0; x <= nums.length - 4; x++) {
            /*// 可优化
            if (target < 0 && nums[x] > 0) {
                break;
            }*/
            // 选择第二个数，从第一个数的下一位选择。一共需要4个数，因此组合中第二个数的索引值最大只能是数组长度的倒数第三个
            for (int y = x + 1; y <= nums.length - 3; y++) {
                // 如果第二个数和之前选择过得一样，那么直接跳过，因为接下来选择结果肯定与之前一样。
                if (y > x + 1 && nums[y] == nums[y - 1]) {
                    continue;
                }
                // 启用双指针，分别从剩余元素的两侧进行枚举，选择合适的元素放入即可
                int left = y + 1;
                int right = nums.length - 1;
                // 选择2个数后的目标和
                int current = target - nums[x] - nums[y];
                // 指针不重合则继续查找
                while (left < right) {
                    // 两数之和小于当前目标值；或者当前的元素与之前选择的元素相同时，要忽略
                    // 则左指针向右侧移动，提升和的大小
                    if (nums[left] + nums[right] < current || (left > y + 1 && nums[left] == nums[left - 1])) {
                        left++;
                    } else if (nums[left] + nums[right] > current || (right < nums.length - 1 && nums[right] == nums[right + 1])) {
                        // 两数之和大于等于当前目标值；或者当前的元素与之前选择的元素相同时，要忽略
                        // 则右指针向左侧移动，减少和的大小
                        right--;
                    } else {
                        // 结果符合，加入到结果集中
                        List<Integer> fit = Lists.newArrayList();
                        fit.add(nums[x]);
                        fit.add(nums[y]);
                        fit.add(nums[left]);
                        fit.add(nums[right]);
                        result.add(fit);
                        // 双指针一起移动：因为只动一个肯定不符合预期
                        // 如果只动一个指针，那么该指针的值发生了变化，另一个指针不动则二者加和肯定不是目标值；如果指针的值没有变化，但由于题干要求不能重复，所以也不符合要求
                        // 因此需要双指针一起移动，提升效率
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }

}
