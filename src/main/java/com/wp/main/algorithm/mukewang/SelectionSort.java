package com.wp.main.algorithm.mukewang;

import com.wp.main.algorithm.mukewang.util.SortedUtil;

/**
 * @Description 选择排序：升序
 * 思想：
 * 从第一个数字开始，遍历该数后面所有的数字，找到最小的数字然后二者互换位置。这样，最小的数字就确定了最终位置。
 * 然后从第二个数字开始，重复如上操作，就会获得第二小的数据。结束后，该数组就按照从小到大的顺序排列完成。
 * @Author admin
 * @Date 2023/3/9 13:30
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 3, 9, 7, 8, 6, 5};
        selectionSort(nums);
        System.out.println(SortedUtil.arraySorted(nums));
        System.out.println("排序后：");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void selectionSort(int[] nums) {
        // 左指针从第一个元素遍历到最后一个元素
        for (int i = 0; i < nums.length; i++) {
            // 当前循环中的最小值对应的索引位置
            int minNumsJ = i;
            // 右指针从左指针的第二个位置开始遍历全部元素，找到最小的那个值对应的索引位置
            for (int j = i + 1; j < nums.length; j++) {
                // 不断循环找最小那个值对应的索引
                if (nums[j] < nums[minNumsJ]) {
                    minNumsJ = j;
                }
            }
            // 右指针结束后，将最小值和当前i的位置进行互换。即将本轮查找的最小值放入最终的位置
            int current = nums[i];
            nums[i] = nums[minNumsJ];
            nums[minNumsJ] = current;
        }
    }
}
