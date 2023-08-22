package com.wp.main.leetcode.medium;

import com.google.common.collect.Lists;

import java.util.ArrayList;
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
//        n = 1;
//        k = 1;
//        System.out.println(individualExecution(n, k));
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
        recursion(stack, n, k, result, 1);
        return result;
    }

    /**
     * 递归逻辑：选择数字
     *
     * @param stackCurrentCombination 栈，存储已经筛选的数字
     * @param n                       n个数字
     * @param k                       k个数字的组合
     * @param result                  结果集
     * @param start                   元素选择的起始位置，每层的选择是从上一层的下一个位置进行筛选
     */
    private static void recursion(Deque<Integer> stackCurrentCombination, int n, int k, List<List<Integer>> result, int start) {
        /**1、递归终止条件**/
        // 已经选中k个元素，则终止递归，将组合放入结果集中
        if (stackCurrentCombination.size() == k) {
            result.add(new ArrayList<>(stackCurrentCombination));
            return;
        }
        /**2、递归执行逻辑**/
        // 2.1、按顺序循环选择，当选择的元素起始位置超过组合目标数量k时，不需要继续遍历了，因为不符合数量要求，所以i <= n - k + 1
        for (int i = start; i <= n - k + 1; i++) {
            // 2.2、当前元素进入已选栈中
            stackCurrentCombination.push(i);
            // 2.3、下一层遍历选择的起始位置从下一位开始
            start++;
            // 2.4、递归选择元素
            recursion(stackCurrentCombination, n, k, result, start);
            /**3、递归结束逻辑**/
            // 清除最后一个选入的元素
            stackCurrentCombination.pop();
        }
    }
}
