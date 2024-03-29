package com.wp.main.algorithm.AlgorithmAndDataStructures.sortAlgorithm.baseSort;

import com.wp.main.algorithm.AlgorithmAndDataStructures.sortAlgorithm.util.SortedUtil;

/**
 * @Description 冒泡排序
 * @Author admin
 * @Date 2023/3/9 16:50
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] nums = {2, 4, 1, 3, 9, 7, 8, 6, 5};
        int[] nums = {2, 4, 20, 102, 7, 34, 56, 23, 68, 17, 29, 39, 405, 698, 47, 58, 68};
        bubbleSort(nums);
        System.out.println(SortedUtil.arraySorted(nums));
        System.out.print("排序后：");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 思路：
     * 不断地从数组首位开始比较相邻两个数字的大小，把大的值放在右边，直到没有相邻元素需要交换位置即可。
     * 由思路可知，每次都是比较相邻两个元素的最大值，因此每一轮都能找到当前未排序数组中的最大值；下一轮就是找次大值，依此类推。所以n个元素需要比较的次数是n-1次
     *
     * @param nums 给定数组
     */
    private static void bubbleSort(int[] nums) {
        int n = nums.length;
        // 未排序元素个数超过1个就需要比较。即n个元素只需要比较n-1次即可，只有一个元素不需要比较
        while (n > 1) {
            // 每次和相邻右侧的数字比较，因此每次比较至未比较的倒数第二个数字即可，因为倒数第一个的相邻右侧已经处理了，不需要比较
            // 随着n的递减，i < n-1 就是查找当前未比较的倒数第二个元素
            for (int i = 0; i < n - 1; i++) {
                // 相邻元素将大的值右移
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i + 1];
                    nums[i + 1] = nums[i];
                    nums[i] = temp;
                }
            }
            // 每次排序完成后，未排序的数组数量减1
            n--;
        }
    }
}
