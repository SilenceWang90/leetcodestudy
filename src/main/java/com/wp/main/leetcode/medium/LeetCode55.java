package com.wp.main.leetcode.medium;

/**
 * @Description 跳跃游戏
 * 给定一个非负整数数组nums，你最初位于数组的第一个下标。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * <p>
 * 示例1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳1步，从下标0到达下标1, 然后再从下标1跳3步到达最后一个下标。
 * <p>
 * 示例2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为3的位置。但该下标的最大跳跃长度是0，所以永远不可能到达最后一个下标。
 * <p>
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 * @Author admin
 * @Date 2023/6/7 13:28
 */
public class LeetCode55 {
    private static int a = 8;
    private int b = 9;

    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(individualExecution(nums));
    }

    private static boolean individualExecution(int[] nums) {
        return recursion(nums, 0);
    }

    private static boolean recursion(int[] nums, int currentIndex) {
        /**1、递归终止条件**/
        if ((currentIndex >= nums.length - 1) || (nums[currentIndex] + currentIndex >= nums.length - 1)) {
            return true;
        }
        int n = nums[currentIndex];
        if (n == 0) {
            return false;
        }
        /**2、递归逻辑：从前往后找，每个节点可达路径再进行递归查找可达路径。
         * 且如果当前节点能到达多个节点，从最远那个开始向后查找，这样效率能快一些**/
        // 从后往前那就得把当前元素前面的所有元素都遍历一遍，因为不知道前面哪个节点可能到达当前节点，所以从后往前的效率不如从前往后
        for (int i = currentIndex + 1; i <= currentIndex + n && i < nums.length; i++) {
            boolean result = recursion(nums, i);
            if (result) {
                return true;
            }
        }
        // 以当前节点出发的任意节点循环结束后，都没有返回true，则从当前节点出发肯定无法抵达最终位置，返回false即可；
        return false;
    }

}
