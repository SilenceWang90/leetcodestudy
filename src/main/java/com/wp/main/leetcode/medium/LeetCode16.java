package com.wp.main.leetcode.medium;

import java.util.Arrays;

/**
 * @Description 最接近的三数之和
 * 给你一个长度为 n 的整数数组nums和一个目标值target。请你从nums中选出三个整数，使它们的和与target最接近。返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * <p>
 * 示例 2：
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 * <p>
 * 提示：
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 * @Author admin
 * @Date 2023/3/12 14:20
 */
public class LeetCode16 {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;

        /*int[] nums = {0,0,0};
        int target = 1;*/
        System.out.println(individualCalculate(nums, target));
    }

    /**
     * 思路：
     * 1、先对数组排序，这样我可以从最小值到最大值遍历开始寻找和目标值接近的结果。数组有了顺序就有了规律。
     * 2、两层循环，第一层为第一个值，第二层循环设定2个指针，分别从两侧开始向内中间找结果。如果加和大了就是右指针大了，右指针移动；反之左指针移动。2个指针重合就停止第二层循环即可
     * 3、不断比较加和结果和目标值的差值，如果比记录的值还小就更新记录。如果等于0就直接跳出循环，因为不可能有比这个值还小的结果了。
     * 如果等于0我们还想遍历的话也可以，左指针和右指针先动哪个都行，因为动右指针加和的结果肯定小于0，动左指针加和的结果肯定大于0,。因此无论先动左还是先动右，下一个移动的都是另一个指针~
     * 不会出现结果遗漏的情况
     * 注：不能像LeetCode15一样等于0的时候左右一起移动，那是因为15题要求结果为0，只动左和右下一个结果肯定不是等于0(数组中无重复或者代码对重复有处理的情况下)，所以15题可以左右一起动
     * 本题要找的最接近的，假设本题要求0不算最接近的话，那么我们一起动2个指针就有可能错过最佳答案，所以本题只能动一个，任意一个都行~
     *
     * @param nums   数组
     * @param target 目标和
     * @return 三数之和
     */
    private static int individualCalculate(int[] nums, int target) {
        // 1、数组升序排序
        Arrays.sort(nums);
        int result = 0;
        // 2、第一层循环。至倒数第三个数就可以了，因为一共要找3个数。在往后的话不够凑齐3个数字
        for (int a = 0; a <= nums.length - 3; a++) {
            // 左指针
            int b = a + 1;
            // 右指针
            int c = nums.length - 1;
            // 左右指针不重合就继续找
            while (b < c) {
                if (nums[b] + nums[c] < target - nums[a] || (b > a + 1 && nums[b] == nums[b - 1])) {
                    // 和小，则左指针移动，因为移动右指针加和只会越来越小，离目标越来越远
                    // 另外，如果b当前位置的值和前一个位置的值相同，那么b继续移动即可，因为已经比较过了
                    b++;
                    result = Math.min(result, nums[a] + nums[b] + nums[c]);
                } else if (nums[b] + nums[c] > target - nums[a] || (c < nums.length - 1 && nums[c] == nums[c + 1])) {
                    // 和大，则右指针移动，因为移动左指针加和只会越来越大，离目标越来越远
                    // 另外，如果c当前位置的值和前一个位置的值相同，那么c继续移动即可，因为已经比较过了
                    c--;
                    result = Math.min(result, nums[a] + nums[b] + nums[c]);
                } else {
                    // nums[b]+nums[c] = target - nums[a]，不可能有比这个结果还接近的值，直接返回
                    result = 0;
                    return result;
                }
            }
        }
        return result;
    }
}
