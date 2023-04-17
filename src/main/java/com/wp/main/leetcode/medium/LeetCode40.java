package com.wp.main.leetcode.medium;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * @Description 组合总和 II
 * 给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 * 注意：解集不能包含重复的组合。
 * <p>
 * 示例1:
 * <p>
 * 输入: candidates =[10,1,2,7,6,1,5], target =8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例2:
 * <p>
 * 输入: candidates =[2,5,2,1,2], target =5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * <p>
 * 提示:
 * <p>
 * 1 <=candidates.length <= 100
 * 1 <=candidates[i] <= 50
 * 1 <= target <= 30
 * @Author admin
 * @Date 2023/4/17 12:23
 */
public class LeetCode40 {

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        /*int[] candidates = {2, 5, 2, 1, 2};
        int target = 5;*/
        System.out.println(individualExecute(candidates, target));
    }

    /**
     * 个人思路：递归回溯
     *
     * @return
     */
    private static List<List<Integer>> individualExecute(int[] candidates, int target) {
        // 排序，为了递归时可以方便地解决数字不能重复选择的问题(相同的放在一起，可以方便判断该数字是否选择过)
        Arrays.sort(candidates);
        List<List<Integer>> result = Lists.newArrayList();
        List<Integer> combinations = Lists.newArrayList();
        recursive(candidates, target, combinations, result, 0);
        return result;
    }

    /**
     * 递归逻辑
     *
     * @param candidates
     * @param target
     * @param combinations
     * @param result
     */
    private static void recursive(int[] candidates, int target, List<Integer> combinations, List<List<Integer>> result, int start) {
        /**
         * 递归终止条件：将符合条件的组合放入结果集中
         */
        if (target == 0) {
            List<Integer> combination = Lists.newArrayList();
            combination.addAll(combinations);
            result.add(combination);
        }
        /**
         * 递归逻辑：不断选择数字，每次递归的选择从上一层的下一个位置开始(题干要求数字不能重复使用)
         * 注：当层需判断该数字是否被选择过，选择过则跳过；下一层不需要判断该层的数字和上一层是否一致
         */
        for (int i = start; i < candidates.length; i++) {
            /** 巧妙解决：因为每一次都是从start开始，因此每一层数字是否选择过得判断条件都是当i>start时，判断当前的数字和前一个数字是否相同，相同则跳过
             * 最开始个人思路是：i > 0 && candidates[i] == candidates[i - 1]，这就错了，因为这导致了递归过程中，下一层的i已经发生了偏移，相当于逻辑上是判断第二次递归选择的数字和第一层递归
             * 选择的数字是否相同了。而我们如果改成从start开始，巧妙地设计了我们每一层的判断位置，防止不同递归层数之间逻辑混乱，每层递归只跟本层选择的数字是否相同做判断即可**/
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            int current = candidates[i];
            target = target - current;
            // 分支剪裁：如果当前选择的数字使得target小于0，则当前递归终止
            if (target < 0) {
                return;
            }
            combinations.add(current);
            // 递归：从下一个位置开始
            recursive(candidates, target, combinations, result, i + 1);
            /**
             * 递归结束，还原target以及已选组合队列(删除队列中最后一个元素)
             */
            target = target + current;
            combinations.remove(combinations.size() - 1);
        }
    }
}
