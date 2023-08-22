package com.wp.main.leetcode.medium;

import com.google.common.collect.Lists;

import java.util.Deque;
import java.util.List;

/**
 * @Description 组合
 * 给定两个整数n和k，返回范围[1, n]中所有可能的k个数的组合。
 * 你可以按 任何顺序 返回答案。
 * <p>
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * <p>
 * 提示：
 * 1 <= n <= 20
 * 1 <= k <= n
 * @Author admin
 * @Date 2023/8/22 10:37
 */
public class LeetCode77 {
    public static void main(String[] args) {
        int n = 4, k = 2;
        System.out.println(individualExecution(n, k));
        n = 1;
        k = 1;
        System.out.println(individualExecution(n, k));
    }

    /**
     * 个人思路：递归查找
     *
     * @param n 数值上限，[1,n]
     * @param k k个数字
     * @return
     */
    private static List<List<Integer>> individualExecution(int n, int k) {
        Deque<Integer> stack = Lists.newLinkedList();
        List<List<Integer>> result = Lists.newArrayList();
        List<Integer> currentCombination = Lists.newArrayList();
        recursion(stack, n, k, result, currentCombination);
        return result;
    }

    /**
     * 递归逻辑：选择数字
     *
     * @param stack              栈，存储已经筛选的数字
     * @param n                  n个数字
     * @param k                  k个数字的组合
     * @param result             结果集
     * @param currentCombination 当前已筛选的集合
     */
    private static void recursion(Deque<Integer> stack, int n, int k, List<List<Integer>> result, List<Integer> currentCombination) {
        /**1、递归终止条件**/
        // 已经选中k个元素，则终止递归，将组合放入结果集中
        if (currentCombination.size() == k) {
            result.add(currentCombination);
            return;
        }
        /**2、递归执行逻辑**/
        for (int i = 1; i < n - k; i++) {

        }

        /**3、递归结束逻辑**/
        // 清除最后一个选入的元素
        stack.pop();
    }
}
