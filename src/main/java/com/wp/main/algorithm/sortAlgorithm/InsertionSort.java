package com.wp.main.algorithm.sortAlgorithm;

import com.wp.main.algorithm.sortAlgorithm.util.SortedUtil;

/**
 * @Description 插入排序：升序，时间复杂度为n的平方
 * 思想：
 * 假设第一个元素在一个有序数组中，下一个元素和该有序数组中的数据进行比较，找到合适的位置插入。
 * @Author admin
 * @Date 2023/3/9 14:55
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 3, 9, 7, 8, 6, 5};
        insertionSortOptimization(nums);
        System.out.println(SortedUtil.arraySorted(nums));
        System.out.println("排序后：");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 思想：
     * 假设第一个元素在一个有序数组中，下一个元素和该有序数组中的数据进行比较，找到合适的位置插入。这个插入的过程是一个不断比较替换的过程。
     * 第二个元素放入有序数组后在进行第三个元素和该有序数组比较，找到合适的位置插入，依此类推。
     * 注：不需要新建一个新的数组，这样会增加空间复杂度，就是在现有数组的基础上进行比较和换位即可。
     *
     * @param nums 目标数组
     */
    private static void insertionSort(int[] nums) {
        // 当前未排序元素的位置
        for (int i = 1; i < nums.length; i++) {
            // 下一个元素和之前的元素比较，找到合适的位置
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                } else {
                    // 当前元素比有序数组中的最大值还大，则当前元素不需要再逐个比较了
                    break;
                }
            }
        }
    }

    /**
     * 思想：
     * 假设第一个元素在一个有序数组中，下一个元素和该有序数组中的数据进行比较，找到合适的位置插入。不同于第一种用法，第一种在内层
     * 循环中要把2个元素互换位置，而需要优化的点就是每次只移动大的值，小的值如果没找到合适的位置就不赋值，直到找到合适的位置再赋值
     *
     * @param nums 目标数组
     */
    private static void insertionSortOptimization(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            // j的声明在外面，对应当前元素temp应在的位置
            int j;
            // 查找当前索引应在的位置
            for (j = i; j > 0; j--) {
                // 当前位置的元素比前一个元素小，则前一个元素后移
                if (temp < nums[j - 1]) {
                    nums[j] = nums[j - 1];
                } else {
                    // 当前位置的元素比前一个元素大，当前元素的位置已确认
                    break;
                }
            }
            nums[j] = temp;
        }
    }
}
