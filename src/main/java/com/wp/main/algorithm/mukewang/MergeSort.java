package com.wp.main.algorithm.mukewang;

import com.wp.main.algorithm.mukewang.util.SortedUtil;

/**
 * @Description 归并排序
 * 思想：将数组不断平均分为2部分，等分到只剩一个元素时，再向回进行归并(递归逻辑)，归并过程中不断对合并的部分进行排序，最后即可完成对整体的排序。
 * 每组排序好的内容在归并过程中需要借助额外的数组空间进行有序数组的合并，因此空间复杂度上归并排序需要额外等长的数组。
 * @Author admin
 * @Date 2023/3/10 14:17
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {2, 4, 20, 102, 7, 34, 56, 23, 68, 17, 29, 39, 405, 698, 47, 58, 68};
        startMergeSort(nums);
        System.out.println(SortedUtil.arraySorted(nums));
        System.out.print("排序后：");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 归并排序入口函数，归并排序需要递归调用，在递归调用外层设置一个入口函数方便处理递归的入参等内容
     *
     * @param nums
     */
    private static void startMergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    /**
     * @param nums  目标数组
     * @param left  当前数组要处理的最左侧元素位置
     * @param right 当前数组要处理的最右侧元素位置
     */
    private static void mergeSort(int[] nums, int left, int right) {
        /**
         * 1、递归终止条件：left>=r。即拆分到当前，只剩下一个元素，不需要再拆分了
         */
        if (left >= right) {
            return;
        }

        /**
         * 2、每一层递归要操作的步骤
         */
        // 2.1、定义中间元素的位置。如果是奇数个则向下取整。此处可能出现溢出问题，暂不考虑。
        int middle = (left + right) / 2;
        mergeSort(nums, middle, right);
    }
}
