package com.wp.main.leetcode.medium;

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
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> list = individualExecute(candidates, target);
        for (List<Integer> listObj : list) {
            System.out.println("分割线");
            for (Integer obj : listObj) {
                System.out.print(obj + ",");
            }
        }
    }

    /**
     * 个人思路
     *
     * @param candidates：给定数组
     * @param target：目标值
     * @return 返回组合数
     */
    private static List<List<Integer>> individualExecute(int[] candidates, int target) {
        /**1、 数组有序排列**/
        Arrays.sort(candidates);
    }

}
