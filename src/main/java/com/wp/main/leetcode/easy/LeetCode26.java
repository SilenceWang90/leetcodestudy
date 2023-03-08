package com.wp.main.leetcode.easy;

/**
 * @Description 删除有序数组中的重复项
 *
 * 给你一个 升序排列 的数组 nums请你原地删除重复出现的元素，使每个元素只出现一次返回删除后数组的新长度。元素的相对顺序应该保持一致 。
 * 由于在某些语言中不能改变数组的长度,所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有k个元素，那么nums的前k个元素应该保存最终结果。
 * 将最终结果插入nums 的前 k 个位置后返回 k 。
 * 要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 判题标准:
 *
 * 系统会用下面的代码来测试你的题解:
 *
 * int[] nums = [...]; // 输入数组
 * int[] expectedNums = [...]; // 长度正确的期望答案
 *
 * int k = removeDuplicates(nums); // 调用
 *
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * 如果所有断言都通过，那么您的题解将被 通过。
 *
 *
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2：
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 *
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按 升序 排列
 *
 * @Author admin
 * @Date 2023/3/8 12:29
 */
public class LeetCode26 {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println("处理后数组长度："+individualExecute(nums));
        for(int num : nums){
            System.out.println("数组元素为："+num);
        }

        /*int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println("处理后数组长度："+individualExecute(nums));
        for(int num : nums){
            System.out.println("数组元素为："+num);
        }*/
    }

    /**
     * 个人思路：
     * 1、双指针，一个指针不断后移，一个指针指向当前最后一个有效元素的索引
     * 2、后移的指针和当前有效元素进行比较，相同的话当前元素直接清空；不同的话放在有效元素的下一个位置。
     * 之所以这样做可以是因为该数组为升序，因此只要清空了和当前有效元素相同的元素，那么该有效元素的下一位一定是空的
     * @param nums 目标数组
     * @return 返回处理后数组的长度
     */
    private static int individualExecute(int[] nums){
        int current = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[current] == nums[i]){
                // 当前元素和当前有效元素相同，则清除该位的元素
                nums[i]=0;
            }else{
                // 下一位元素和当前有效元素不同，则移位当前元素到有效元素的下一位，当前元素之前所在的位置清空
                current++;
                nums[current] = nums[i];
                // 可以不清空
//                nums[i] = 0;
            }
        }
        return current+1;
    }
}
