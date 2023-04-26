package com.wp.main.leetcode.medium;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Description 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
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
        int[] nums = {1, 1, 2};
//        int[] nums = {1, 2, 3};
        System.out.println(individualExecute(nums));
    }

    private static List<List<Integer>> individualExecute(int[] nums) {
        List<List<Integer>> result = Lists.newArrayList();


        return result;
    }


}
