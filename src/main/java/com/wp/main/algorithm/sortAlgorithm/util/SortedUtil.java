package com.wp.main.algorithm.sortAlgorithm.util;

/**
 * @Description 排序工具类
 * @Author admin
 * @Date 2023/3/9 14:48
 */
public class SortedUtil {
    private SortedUtil() {
    }


    /**
     * 判断数组是否排序(升序)成功
     *
     * @param nums 目标数组
     * @return true成功/false失败
     */
    public static boolean arraySorted(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
