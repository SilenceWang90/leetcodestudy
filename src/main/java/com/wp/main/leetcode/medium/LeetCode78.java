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
        // 当前已选的组合
        List<Integer> currentCombination = Lists.newArrayList();
        recursion(nums, result, currentCombination, 1, 0);
        // 空集合也算
        result.add(new ArrayList<>());
        return result;
    }

    /**
     * 递归逻辑
     *
     * @param nums               给定数组
     * @param result             结果集
     * @param currentCombination 当前遍历生成的集合
     * @param n                  当前要选几个元素
     * @param start              下一层递归起始位置
     */
    private static void recursion(int[] nums, List<List<Integer>> result, List<Integer> currentCombination, int n, int start) {
        /**1、递归终止条件**/
        if (currentCombination.size() == n) {
            List<Integer> temp = Lists.newArrayList(currentCombination);
            result.add(temp);
            return;
        }

        /**2、递归处理逻辑**/
        // 2.1、n为统计每次要选组合的数字数量，每次递归结束则组合中数字数量也会增加
        while (n <= nums.length) {
            for (int i = start; i < nums.length; i++) {
                // 向当前集合加入选择的元素
                currentCombination.add(i);
                // 下一层递归起始位置+1，因为要求不能重复
                start++;
                // 递归选择
                recursion(nums, result, currentCombination, n, start);
                /**3、递归结束操作*/
                // 将最后添加的元素清除
                currentCombination.remove(currentCombination.size() - 1);
            }
            // 针对新一轮的选择，组合数量+1，start起始位置归0
            n++;
            start = 0;
        }
    }
}
