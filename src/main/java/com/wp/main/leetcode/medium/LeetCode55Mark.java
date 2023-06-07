package com.wp.main.leetcode.medium;

/**
 * Mark：贪心算法
 */

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
public class LeetCode55Mark {
    private static int a = 8;
    private int b = 9;

    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};
        int[] nums = {3, 2, 1, 0, 4};
//        System.out.println(individualExecution(nums));
        System.out.println(standardExecution(nums));
    }

    /**
     * 官方答案：贪心算法
     * 根据题目的描述，只要存在一个位置x，它本身可以到达，并且它跳跃的最大长度为x+nums[x]，这个值大于等于y，即x+nums[x]≥y，那么位置y也可以到达。
     * 这样一来，我们依次遍历数组中的每一个位置，并实时维护最远可以到达的位置。对于当前遍历到的位置x，如果它在最远可以到达的位置的范围内，那么
     * 我们就可以从起点通过若干次跳跃到达该位置，因此我们可以用x+nums[x]更新最远可以到达的位置。在遍历的过程中，如果最远可以到达的位置大于等于数组中的
     * 最后一个位置，那就说明最后一个位置可达，我们就可以直接返回True作为答案。反之，如果在遍历结束后，最后一个位置仍然不可达，我们就返回False作为答案。
     *
     * @param nums
     * @return
     */
    private static boolean standardExecution(int[] nums) {
        // 初始化最大可达索引值为nums[0]的值
        int maxLength = nums[0];
        /** 从第二位开始，判断当前节点是否在当前最大可达索引值得范围内
         * 1、如果在即当前遍历的元素可以抵达：那么判断能否更新最大可达索引值，如果可以更新则更新，不能更新则不处理
         * 2、如果不在即当前遍历的元素不可以抵达：那么判断当前遍历的i是否已到达数组最后一位，如果没到那么最后一位不可达到，返回false；如果能到，那么最后一位可以达到，返回true。
         **/
        for (int i = 1; i < nums.length; i++) {
            if (i <= maxLength) {
                maxLength = Math.max(i + nums[i], maxLength);
            } else {
                // 循环中任意一个元素不可抵达则那么即意味着最后一个元素不可达。包括最后一个元素，因为遍历到最后一个元素不可达一样是不可达~
                return false;
            }
        }
        // 遍历结束，由于方法没有提前返回结果，意味着所有元素均在最大可达索引值的范围内，因此最后一个元素也是可达的
        return true;
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
