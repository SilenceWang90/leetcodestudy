package com.wp.main.leetcode.medium;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * @Description 全排列 II
 * 给定一个可包含重复数字的序列nums，按任意顺序返回所有不重复的全排列。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * @Author admin
 * @Date 2023/4/23 12:34
 */
public class LeetCode47 {
    public static void main(String[] args) {
//        int[] nums = {1, 1, 2};
        int[] nums = {1, 2, 3};
        System.out.println(individualExecute(nums));
    }

    private static List<List<Integer>> individualExecute(int[] nums) {
        // 数组排序，便于解决重复的问题
        Arrays.sort(nums);
        // 结果集
        List<List<Integer>> result = Lists.newArrayList();
        // 将目标数组转为集合，便于元素的加入和删除
        List<Integer> numsList = Lists.newLinkedList();
        for (int num : nums) {
            numsList.add(num);
        }
        // 暂存当前已选数字的集合
        List<Integer> combinations = Lists.newArrayList();
        recursion(numsList, result, combinations);
        return result;
    }


    private static void recursion(List<Integer> numsList, List<List<Integer>> result, List<Integer> combinations) {
        // 1、递归终止条件：选择完成，放入到最终集合中
        if (numsList.size() == 0) {
            List<Integer> list = Lists.newArrayList();
            list.addAll(combinations);
            result.add(list);
        }

        // 2、递归逻辑
        for (int i = 0; i < numsList.size(); i++) {
            // 当前数字重复，意味着已经被选择过，直接跳过
            if (i > 0 && numsList.get(i) == numsList.get(i - 1)) {
                continue;
            }
            int current = numsList.get(i);
            combinations.add(current);
            numsList.remove(i);
            recursion(numsList, result, combinations);
            // 3、递归结束后
            // 删除已选集合中的最后一个元素，即当前选择的元素
            combinations.remove(combinations.size() - 1);
            // 将该元素填回到目标集合中
            numsList.add(i, current);
        }
    }


}
