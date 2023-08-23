package com.wp.main.leetcode.medium;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 子集
 * 给你一个整数数组nums，数组中的元素互不相同。返回该数组所有可能的子集（幂集）。
 * 解集不能包含重复的子集。你可以按任意顺序返回解集。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums中的所有元素互不相同
 * @Author admin
 * @Date 2023/8/23 9:33
 */
public class LeetCode78 {
    public static void main(String[] args) {

    }

    /**
     * 个人思路：递归回溯
     *
     * @param nums 给定目标数组
     * @return 子集集合
     */
    private static List<List<Integer>> individualExecution(int[] nums) {
        List<List<Integer>> result = Lists.newArrayList();
        // 空集合也算
        result.add(new ArrayList<>());
        // 当前已选的组合
        List<Integer> currentCombination = Lists.newArrayList();
        recursion(nums, result, currentCombination);
        return result;
    }

    /**
     * 递归逻辑
     *
     * @param nums               给定数组
     * @param result             结果集
     * @param currentCombination 当前遍历生成的集合
     */
    private static void recursion(int[] nums, List<List<Integer>> result, List<Integer> currentCombination) {

    }
}
