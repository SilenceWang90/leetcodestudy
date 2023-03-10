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
     * 归并排序入口函数，归并排序需要递归调用，在递归调用外层设置一个入口函数方便处理递归的入参、起始情况等内容
     * 递归过程中可能起始部分的内容和递归过程中的每一步处理不太一样，我们争取保证递归过程的一致性，所以起始部分的处理或者有入参的调整时
     * 这种上一层包装一下再调用，逻辑上比较清晰
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
         * 1、递归终止条件：left>=r。即数组通过2分拆分到当前，每组只剩下一个元素，不需要再拆分了
         */
        if (left >= right) {
            return;
        }

        /**
         * 2、每一层递归要操作的步骤
         */
        // 2.1、对当前数组进行拆分：定义中间元素middle的位置，如果是奇数个则向下取整。因为每一个数组都要从middle切分被拆分成2组，这2组数组的索引区间分别是[left,middle]和[middle+1,right]
        // 所以即使是奇数个，也不会因为无法整除而出现数据丢失的问题。
        // 此处加法可能出现溢出问题，暂不考虑。
        int middle = (left + right) / 2;
        // 2.2、找到中间位置后，则下一次拆分就是2组：
        // （1）从left到middle(下一次的right)继续拆分，不断地缩小left和right的间隔，直到left>=right，拆分结束
        mergeSort(nums, left, middle);
        // （2）从middle+1(下一次的left)到right继续拆分，不断地缩小left和right的间隔，直到left>=right，拆分结束
        mergeSort(nums, middle + 1, right);
        // 2.3、当前拆分结束后，进行2个有序数组的merge操作

    }

    /**
     * 对2个升序排序的数组[left,middle][middle+1,right]进行升序合并
     *
     * @param nums   原目标数组
     * @param left   当前数组的最左侧元素索引
     * @param middle 当前数组的中间元素的索引
     * @param right  当前数组的最右侧元素索引
     */
    private static void mergeAscSortedArray(int[] nums, int left, int middle, int right) {

    }
}
