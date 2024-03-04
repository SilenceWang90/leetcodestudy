package com.wp.main.algorithm.AlgorithmAndDataStructures.sortAlgorithm.advancedSort;

import com.wp.main.algorithm.AlgorithmAndDataStructures.sortAlgorithm.util.SortedUtil;

/**
 * @Description 快速排序
 * @Author admin
 * @Date 2023/3/15 17:26
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {2, 4, 20, 102, 7, 34, 56, 23, 68, 17, 29, 39, 405, 698, 47, 58, 68};
//        int[] nums = {1,2,3,4,5,10,6,7,8};
//        int[] nums = {3, 4, 2, 1};
        startQuickSort(nums);
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
    private static void startQuickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }


    /**
     * 递归过程：对数组[l,r]区间的内容进行排序
     *
     * @param nums 目标数组
     * @param l    数组左指针
     * @param r    数组右指针
     */
    private static void quickSort(int[] nums, int l, int r) {
        // 随着不断进行分组，l和r的间距会越来越小，直到l>=r
        // l>=r意味着当前数组只有一个元素(l=r)，或者没有元素(l>r)
        if (l >= r) {
            return;
        }
        // 针对每个[l,r]区间进行partition排序，即将比指定元素大的元素放在左侧，比指定元素小的元素放在右侧。
        // 返回partition排序中，指定元素经排序后的位置索引


        // 多种快速排序的思路
        /**
         * 单指针，从第一个元素的后面元素开始遍历，对数组进行二分
         * int p = partition(nums, l, r);
         * // 递归：以p为分界，继续进行快速排序的逻辑
         * quickSort(nums, l, p - 1);
         * quickSort(nums, p + 1, r);
         */

        /**
         * 双指针：双路排序，针对数组中大量重复数据排序时可能时间复杂度退化至O(n²)的问题优化
         * int p = partition2(nums, l, r);
         * // 递归：以p为分界，继续进行快速排序的逻辑
         * quickSort(nums, l, p - 1);
         * quickSort(nums, p + 1, r);
         */


        /**
         * 三路排序：对和当前partition元素相等的元素一同处理，防止数组拆分不均造成算法时间复杂度回退，也减少了递归次数
         */
        int[] pArray = partition3(nums, l, r);
        quickSort(nums, l, pArray[0]);
        quickSort(nums, pArray[1], r);

    }

    /**
     * 对当前数组进行排序，索引p左侧的元素均比nums[p]小，索引p右侧的元素均比nums[p]大
     *
     * @param nums 给定数组
     * @param l    数组左指针
     * @param r    数组右指针
     * @return 索引p
     */
    private static int partition(int[] nums, int l, int r) {
        // 选择当前给定数组的第一个元素为标准元素
        int partition = nums[l];
        // 标准元素应在位置的索引(比标准元素小的数组中最后一个位置的索引)
        int p = l;
        for (int i = l + 1; i <= r; i++) {
            // 遍历的元素小于标准元素，则遍历的元素和标准元素右侧位置的元素进行互换，标准元素所在位置索引右移;如果遍历的元素大于标准元素，符合要求不需要移动数组
            if (nums[i] < partition) {
                // 遍历的元素和标准元素右侧位置的元素进行互换
                int temp = nums[i];
                nums[i] = nums[p + 1];
                nums[p + 1] = temp;
                // 标准元素所在位置索引右移
                p++;
            }
        }
        // 数组遍历完成，标准元素放入指定位置
        int temp = nums[p];
        nums[p] = nums[l];
        nums[l] = temp;
        return p;
    }

    /**
     * 双路排序：对当前数组进行排序，优化数组中可能出现大量重复元素的情况
     *
     * @param nums 给定数组
     * @param l    数组左指针
     * @param r    数组右指针
     * @return 索引p
     */
    private static int partition2(int[] nums, int l, int r) {
        // 选择当前给定数组的第一个元素为标准元素。
        // 此处可优化为选择[l,r]的随机数
        int partition = nums[l];
        // i从左向右遍历，j从右向左遍历
        // nums[l+1...i)<=partition；nums(j...r]>=partition
        int i = l + 1, j = r;
        while (true) {
            // i遍历查找比标准元素partition大的元素，防止素组越界i <= r
            while (i <= r && nums[i] <= partition) {
                i++;
            }
            // j遍历查找比标准元素partition小的元素，防止素组越界j >= l + 1
            while (j >= l + 1 && nums[j] >= partition) {
                j--;
            }
            // i与j重合或者超过j，所有元素遍历完成，当前数组的针对partition的元素分组已经结束
            // 也有可能由于参数设置错误l初始就大于r，变相的实现了防御型编程
            if (i >= j) {
                break;
            }
            // 交换nums[i]和nums[j]的位置，将各元素放入指定的位置
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        // 排序完成，将partition元素放入指定位置(由于上面的排序把i移动到了大于partition的位置，因此partition实际要和第i-1个元素交换位置，才能保证partition左侧都是小于等于他，右边是大于等于它)
        nums[l] = nums[i - 1];
        nums[i - 1] = partition;
        return i - 1;
    }

    /**
     * 三路排序：对当前数组进行排序，优化数组中可能出现大量重复元素的情况，比双路排序优化在对选定的partition元素重复的元素的处理
     *
     * @param nums 给定数组
     * @param l    数组左指针
     * @param r    数组右指针
     * @return 返回数组第一个值是左数组的最后一个索引位置；第二个值是右数组的第一个位置
     */
    private static int[] partition3(int[] nums, int l, int r) {
        // 选择当前给定数组的第一个元素为标准元素。
        // 此处可优化为选择[l,r]的随机数
        int partition = nums[l];
        // lt为小于partition元素的最后一个位置索引；gt为大于partition元素的第一个位置索引
        // nums[l+1...lt]<partition；nums[lt+1,gt-1]=partition；nums[gt...r]>partition
        // lt和gt的初始值判定：极限判断，如果遍历的第一个值就比partition小或者大，那么按照下面的换位逻辑将出现问题，因为我们要将lt+1和gt-1的位置和
        // nums[i]互换，但是nums[lt]和nums[gt]的位置还没处理就被漏掉了，因此要把lt和gt的初始位置向两侧挪动一下，可以保证换位逻辑不会因为极限值(初始就换位置)受到影响
        int lt = l, gt = r + 1;
        // 遍历指针i，从l+1(partition元素的下一个元素)的位置开始遍历
        int i = l + 1;
        // i和gt未重合，即有未遍历的元素需要处理
        while (i < gt) {
            // 当前元素小于partition
            if (nums[i] < partition) {
                // 将当前元素和lt+1的元素互换位置，lt自增一位，i自增即可。
                // 此操作是增加了nums[l+1...lt]的大小，小于partition的区域增加
                int temp = nums[i];
                nums[i] = nums[lt + 1];
                nums[lt + 1] = temp;
                lt++;
                i++;
            } else if (nums[i] > partition) {
                // 当前元素大于partition，当前元素和gt的前一位元素互换位置，gt左移一位，i不动。i不动是因为又换过去一个未遍历过得元素，继续遍历
                // 此操作是增加了nums[gt...r]的大小，大于partition的区域增加
                int temp = nums[i];
                nums[i] = nums[gt - 1];
                nums[gt - 1] = temp;
                gt--;
            } else {
                // 当前元素等于partition
                // 遍历指针继续移动即可，不需要做元素调整，相当于增加了nums[lt+1...i]的大小，等于partition的区域增加
                i++;
            }
        }
        // 遍历完成，将标准元素p放入指定位置：和lt的位置交换一下即可
        nums[l] = nums[lt];
        nums[lt] = partition;
        // 返回当前数组中partion元素的前后位置索引，即是下一个递归过程中数组的左右边界
        return new int[]{lt - 1, gt};
    }
}
