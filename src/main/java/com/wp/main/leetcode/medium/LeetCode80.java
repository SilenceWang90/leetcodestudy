package com.wp.main.leetcode.medium;

/**
 * @Description 删除有序数组中的重复项 II
 * 给你一个有序数组nums，请你原地删除重复出现的元素，使得出现次数超过两次的元素只出现两次，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用O(1)额外空间的条件下完成。
 * <p>
 * 说明：
 * 为什么返回数值是整数，但输出的答案是数组呢？
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下:
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2：
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。
 * <p>
 * <p>
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按升序排列
 * @Author admin
 * @Date 2023/9/2 10:46
 */
public class LeetCode80 {
    public static void main(String[] args) {

    }

    /**
     * 个人思路：
     * 双指针：blank指针指向第一个为空的索引位置；current，当前指针遍历数组
     * preElement：前一个元素，用于判断是否是已遍历的同一个元素
     * num：记录当前元素的个数。
     * length：记录有效元素的个数
     * （1）如果当前元素与preElement相同，则++num；如果++num>2则删除当前元素
     * （2）如果当前元素与preElement不相同，则num=1，且将该元素放置在blank索引位置、当前索引位置元素、blank++、preElement赋值为当前元素
     *
     * @param nums 给定数组
     * @return 返回处理后的数组长度
     */
    private static int individualExecution(int[] nums) {
        // 第一个空位索引的位置
        int blank = 0;
        // 当前元素的个数
        int num = 0;
        // 当前已遍历的元素
        int preElement = -1;
        // 有效元素的个数（真实数组长度）
        int length = 0;
        for (int current = 0; current < nums.length; current++) {
            if (nums[current] == preElement) {
                /** 当前元素与preElement相同**/
                num++;
                // 元素重复超过2次，且没有出现空位时，blank初始化为当前位置
                if (num > 2 && blank == 0) {
                    blank = current;
                }
                // 元素未重复超过2次，
                if (num <= 2) {
                    // 统计有效元素个数
                    length++;
                    // 如果存在空位则交换元素至空白位
                    if (blank > 0) {
                        int temp = nums[current];
                        nums[current] = nums[blank];
                        nums[blank] = temp;
                    }

                }
            } else {
                /** 当前元素与preElement不同**/
                num = 1;
                // 统计有效元素个数
                length++;
                // 如果存在空位则交换元素至空白位
                if (blank > 0) {
                    int temp = nums[current];
                    nums[current] = nums[blank];
                    nums[blank] = temp;
                }
            }
        }
        return length;
    }
}
