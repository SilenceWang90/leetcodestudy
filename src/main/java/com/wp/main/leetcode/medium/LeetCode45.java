package com.wp.main.leetcode.medium;

/**
 * @Description 跳跃游戏 II
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * @Author admin
 * @Date 2023/4/22 12:16
 */
public class LeetCode45 {
    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(individualExecute(nums));
    }

    /**
     * 思路：动态规划
     * 1、遍历每个节点，确认该节点可达的每个节点，该节点的最小跳跃次数+1
     * 2、加1的时候要累计出发节点的最小跳跃次数值，这样才是可达节点的最小跳跃次数
     * 找到去每个点上最优的解
     *
     * @param nums 给定数组
     * @return 最小跳跃次数
     */
    private static int individualExecute(int[] nums) {
        // 1、等长数组记录目标数组对应位置上的最小跳跃次数
        int[] record = new int[nums.length];
        // 2、遍历数组，只需要到倒数第二个元素即可(因为题干要求的是到达最后一个节点~)
        for (int i = 0; i < nums.length - 1; i++) {
            int current = nums[i];
            // 遍历当前节点可达的所有节点
            while (current > 0) {
                // 当前节点可达的位置上没有记录，则记录最小可跳跃次数
                // 处理数组可能越界的问题
                if ((i + current) < nums.length && record[i + current] == 0) {
                    // 当前可达节点的最小跳跃次数=当前节点的最小跳跃次数+1
                    record[i + current] = record[i] + 1;
                    // 判断是否到已经达最终节点，如果达到则直接返回结果
                    if (i + current == nums.length - 1) {
                        return record[i + current];
                    }
                }
                // 遍历所有当前节点的可达节点
                current--;
            }
        }
        return record[nums.length - 1];
    }
}
