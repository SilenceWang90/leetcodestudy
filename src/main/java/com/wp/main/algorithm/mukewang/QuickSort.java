package com.wp.main.algorithm.mukewang;

import com.wp.main.algorithm.mukewang.util.SortedUtil;

/**
 * @Description 快速排序
 * @Author admin
 * @Date 2023/3/15 17:26
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {};
        quickSort(nums);
        System.out.println(SortedUtil.arraySorted(nums));
        System.out.print("排序后：");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 使用快速排序对nums进行排序
     *
     * @param nums 给定数组
     */
    private static void quickSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

        }
    }


}
