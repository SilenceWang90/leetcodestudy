package com.wp.main.leetcode.easy;

/**
 * @Description 移除元素
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1)额外空间并原地修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 说明:
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下:
 *
 * //nums是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *  print(nums[i]);
 * }
 *
 *
 * 示例 1：
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而nums = [2,2,3,3]或nums = [2,2,0,0]，也会被视作正确答案。
 *
 * 示例 2：
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 *
 * 提示：
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 *
 * @Author admin
 * @Date 2023/3/8 16:44
 */
public class LeetCode27 {
    public static void main(String[] args) {
        /*int val = 3;
        int[] nums = {3,2,2,3};*/

        int val = 2;
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(individualExecute(nums,val));
        for(int num : nums){
            System.out.println("处理后数组元素："+num);
        }
    }

    /**
     * 个人思路：双指针
     * 指针1不断右移遍历数组查找相同数字
     * 指针2不断右移查找空白位置，找到一个空白位置(按题目要求数组中的元素>=0且<=50，我们设定-1就是清除重复元素后的空白位置)就停留，准备放置指针1找到的元素
     * @param nums
     * @param val
     * @return
     */
    private static int individualExecute(int[] nums, int val) {
        // 重复元素个数
        int spaceNums = 0;
        // 当前空格(-1)元素所在位置
        int current = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                // 1、如果当前位置的元素和给定元素相同
                // 1.1、清除当前位置的元素
                nums[i] = -1;
                /*// 1.2、如果当前空白元素指针未指向空白元素位置，则移动到刚清理的位置上
                if(nums[current]!=-1){
                    current = i;
                }*/
                // 1.2、空格数加1
                spaceNums++;
            }else{
                // 2、如果当前位置的元素和给定元素不同
                // 且已经清理过重复元素的时候才需要移动元素，否则不需要移动元素
                if(spaceNums>0){
                    // 2.1、current指针不断右移，直到命中元素为-1的位置
                    while(nums[current]!=-1){
                        current++;
                    }
                    // 2.2、找到空白位置后将当前元素赋值到空白位置。
                    nums[current] = nums[i];
                    // 2.3、移走元素的位置清空
                    nums[i] = -1;
                }
            }
        }
        // 清理数组后，实际有效数组长度
        return nums.length-spaceNums;
    }
}
