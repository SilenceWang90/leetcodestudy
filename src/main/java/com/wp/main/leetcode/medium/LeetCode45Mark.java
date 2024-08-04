package com.wp.main.leetcode.medium;

/**
 * @Description 跳跃游戏 II
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 *
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 *
 * 提示:
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * 题目保证可以到达 nums[n-1]
 * @Author admin
 * @Date 2023/4/22 12:16
 */
public class LeetCode45Mark {
    public static void main(String[] args) {
        int[] nums = {2,3,0,1,4};
        System.out.println(individualExecute(nums));
    }

    /**
     * 官方解法：贪心算法：每次跳跃的最大位置就是该次跳跃的边界，下一次跳跃最大的位置取决于当次抵达最大位置前，每一个位置能抵达的最大位置的最大值
     * @param nums
     * @return
     */
    private static int standardExecute(int[] nums){
        int length = nums.length;
        // end维护的是当前这一跳能达到的最右位置，若要超过该位置必须要进行一次跳跃，因此需将跳跃次数加1，并更新这次跳跃能到达的最右位置
        int end = 0;
        // 目前能跳到的最远位置
        int maxPosition = 0;
        int steps = 0;
        /**
         * 1、拿到每个位置能跳到的最远距离(i + nums[i])，和已知能跳跃的最远距离maxPosition，二者取最大值更新当前能到达的最远距离
         * 2、如果遍历i到达了上一次能跳跃最远距离的边界，那么接下来：
         *  2.1、记录跳跃次数，steps+1。因为如果上一次跳跃已到达最远距离，那么再往后肯定就得再次跳跃才可以到达，所以step+1
         *  2.2、更新下一次跳跃能到达的最远位置maxPosition为边界end。因为到达边界前已经遍历了边界之内的所有节点，得到了这些节点所能到达最远的距离。
         *  因此到达上一次边界后，将最新的最远的距离作为下一次跳跃的边界，
         */
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
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
