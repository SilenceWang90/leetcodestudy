package com.wp.main.leetcode.medium;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * @Description 组合总和
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target的所有不同组合，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates中的同一个数字可以无限制重复被选取如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为target的不同组合数少于150个。
 * <p>
 * 示例1：
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * <p>
 * 示例2：
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * <p>
 * 示例 3：
 * 输入: candidates = [2], target = 1
 * 输出: []
 * <p>
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * candidates 的所有元素 互不相同
 * 1 <= target <= 40
 * @Author admin
 * @Date 2023/4/16 11:26
 */
public class LeetCode39 {
    public static void main(String[] args) {
        /*int[] candidates = {2, 3, 6, 7};
        int target = 7;*/
        int[] candidates = {2, 3, 5};
        int target = 8;
        /*int[] candidates = {2};
        int target = 1;*/
        List<List<Integer>> list = individualExecute(candidates, target);
        System.out.println(list);
    }

    /**
     * 个人思路：递归回溯
     * 重点：如何解决可以重复选自己但是组合不能重复
     * 将当前所选的索引作为递归参数进行传递，这样，每次都从同一个数字进行选择就不会出现组合重复的问题.
     * 不能每层递归都从初始(索引为0)的位置开始，这样必然会造成组合的重复。可以设想如果每个数字只能选一次，那我们每一层递归的遍历肯定是从上一层递归遍历位置的下一个位置开始遍历。
     * 但是如果要求每个数字可以重复使用的话，其实就是每一层遍历都跟上一层的遍历位置相同即可，不能每一层都从起始开始，这样必然重复(比如
     * 第一层选了2，第二层选3，第三层选了2，和为7；然后第一层选了3，第二层和第三层都从起始位置开始所以都可以选择到2，这样的话{2,3,2}和{3,2,2}这两种组合就是重复的)
     * 所以造成重复的原因就是每次都从起始位置开始，导致已经遍历过得情况在后续的递归中又被遍历了一遍，只是顺序不同了而已。
     *
     * @param candidates：给定数组
     * @param target：目标值
     * @return 返回组合数
     */
    private static List<List<Integer>> individualExecute(int[] candidates, int target) {
        /**1、数组有序排列**/
        // 使数组升序，形成有规律的队列，这样在遍历的时候可以减少遍历次数
        Arrays.sort(candidates);
        /**2、组合查找**/
        List<List<Integer>> result = Lists.newArrayList();
        List<Integer> combinations = Lists.newArrayList();
        // 递归回溯
        recursiveExecute(candidates, target, combinations, result, 0);
        return result;
    }

    /**
     * 每次递归查找一个元素，每次都是从第上一层开始的位置开始(因为允许重复)，只要和小于目标值即可
     *
     * @param candidates   待定数组
     * @param target       目标和
     * @param combinations 符合条件的组合
     * @param result       结果集
     */
    private static void recursiveExecute(int[] candidates, int target, List<Integer> combinations, List<List<Integer>> result, int start) {
        /**1、递归回溯结束条件**/
        // target<0意味着当前组合不是解，在循环中判断，可以进行分支裁剪，提升效率
        /*if (target < 0) {
            return;
        }*/
        // target==0意味着当前解符合条件，放入结果集中
        // 因为combinations参数会不断变化不能直接放入结果集，需要放入新的集合中
        if (target == 0) {
            List<Integer> combination = Lists.newArrayList();
            combination.addAll(combinations);
            result.add(combination);
        }
        /**2、递归回溯逻辑**/
        for (int i = start; i < candidates.length; i++) {
            // 获取当前的元素
            int current = candidates[i];
            // 选定一个元素后，目标和更新
            target = target - current;
            // 优化：当当前选的值使得和大于target，则不需要再遍历其余数字(升序数组，数字只会越选越大)
            if (target < 0) {
                return;
            }
            // 将选定的元素放入组合中
            combinations.add(current);
            // 递归回溯
            recursiveExecute(candidates, target, combinations, result, i);
            /**3、递归回溯结束操作**/
            // 3.1、还原target，并将元素从已选中集合中清除，即清除当前集合中的最后一个元素
            target = target + current;
            combinations.remove(combinations.size() - 1);
        }
    }
}
