package com.wp.main.leetcode.medium;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Description 全排列
 * 给定一个不含重复数字的数组nums，返回其 所有可能的全排列。你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * <p>
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * @Author admin
 * @Date 2023/4/23 12:34
 */
public class LeetCode46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
//        int[] nums = {0,1};
//        int[] nums = {1};
        System.out.println(individualExecute(nums));
    }

    private static List<List<Integer>> individualExecute(int[] nums) {
        List<Integer> numsList = Lists.newArrayList();
        // 转成队列，方便清除和添加元素
        for (int num : nums) {
            numsList.add(num);
        }
        List<List<Integer>> result = Lists.newArrayList();
        List<Integer> combination = Lists.newArrayList();
        recursive(numsList, combination, result);
        return result;
    }

    private static void recursive(List<Integer> numsList, List<Integer> combinations, List<List<Integer>> result) {
        // 1、递归终止条件
        if (numsList.size() == 0) {
            List<Integer> combination = Lists.newArrayList();
            combination.addAll(combinations);
            result.add(combination);
        }
        // 2、递归逻辑
        for (int i = 0; i < numsList.size(); i++) {
            int current = numsList.get(i);
            combinations.add(current);
            // 删除数组中已被选择的元素(因为元素不重复，所以可以直接删除)
            numsList.remove(i);
            recursive(numsList, combinations, result);
            // 3、递归结束
            // 放入原位，必须保持位置不变，否则容易出现重复组合
            numsList.add(i, current);
            combinations.remove(combinations.size() - 1);
        }
    }
}
