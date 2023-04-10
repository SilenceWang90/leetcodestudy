package com.wp.main.leetcode.medium;

/**
 * @Description 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组nums，和一个目标值target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值target，返回[-1, -1]。
 * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
 * <p>
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * <p>
 * 示例2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * <p>
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * 提示：
 * 0 <= nums.length <= 105
 * -109<= nums[i]<= 109
 * nums是一个非递减数组
 * -109<= target<= 109
 * @Author admin
 * @Date 2023/4/10 15:55
 */
public class LeetCode34 {

    public static void main(String[] args) {
        /*int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;*/
        /*int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;*/
        /*int[] nums = {};
        int target = 0;*/
        int[] nums = {2, 2};
        int target = 2;
        System.out.println(individualExecute(nums, target)[0] + "," + individualExecute(nums, target)[1]);
    }


    /**
     * 个人思路：二分法
     * 1、根据二分法进行数据查找，锁定目标数字范围
     * 2、找到目标数字后停止循环，并设定start和end指针从当前位置向两侧遍历，直到检索到非目标值的数字
     *
     * @param nums   给定数组
     * @param target 目标值
     * @return 目标值的索引
     */
    private static int[] individualExecute(int[] nums, int target) {
        int[] result = {-1, -1};
        /**1、特殊情况处理**/
        // 数组为空
        if (nums.length == 0) {
            return result;
        }
        // 数组只有1个元素
        if (nums.length == 1 && nums[0] == target) {
            result[0] = 0;
            result[1] = 0;
            return result;
        }
        // 数组的左右两侧指针
        int left = 0, right = nums.length - 1;
        int current = -1;
        /**2、只要左指针未超过右指针，即可进行遍历查找**/
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target < nums[middle]) {
                // target在左侧，锁定范围在[left,middle - 1]
                right = middle - 1;
            } else if (target > nums[middle]) {
                // target在右侧，锁定范围在[middle + 1,right]
                left = middle + 1;
            } else {
                // 等于时记录索引位置并退出循环
                current = middle;
                break;
            }
        }
        // 意味着找到了target值
        if (current != -1) {
            int start = current, end = current;
            while ((start - 1 >= 0 && nums[start - 1] == target)
                    || (end + 1 < nums.length && nums[end + 1] == target)) {
                if ((start - 1 >= 0 && nums[start - 1] == target)) {
                    start--;
                }
                if ((end + 1 < nums.length && nums[end + 1] == target)) {
                    end++;
                }
            }
            result[0] = start;
            result[1] = end;
        }
        /**3、**/
        return result;
    }


}
