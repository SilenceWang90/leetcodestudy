package com.wp.main.algorithm.mukewang;

import com.wp.main.algorithm.mukewang.util.SortedUtil;

/**
 * @Description 归并排序
 * 思想：
 *
 * @Author admin
 * @Date 2023/3/10 14:17
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {2, 4, 20, 102, 7, 34, 56, 23, 68, 17, 29, 39, 405, 698, 47, 58, 68};
        mergeSort(nums);
        System.out.println(SortedUtil.arraySorted(nums));
        System.out.print("排序后：");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void mergeSort(int[] nums){

    }
}
