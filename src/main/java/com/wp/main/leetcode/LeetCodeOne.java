package com.wp.main.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname LeetCodeOne
 * @Description 两数之和，题干：
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @Date 2020/11/3 16:26
 * @Created by wangpeng116
 */
public class LeetCodeOne {
    public static void main(String[] args) {
        Integer[] nums = {1, 3, 4, 5, 6, 8, 9};
        Integer target = 10;
        Integer[] result = standardExecute(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println("索引为：" + result[i]);
        }
    }

    /**
     * 标准答案解题思路：
     * （1）声明一个hashmap，通过该hashmap存储已经遍历过的数据。key存储数组中的数据，value存储该数据在数组中的索引
     * （2）判断：如果hashmap中存在目标结果(target)减去当前遍历数据(nums[i])的entryset对象，则证明找到了满足target的两个数字
     *
     * @param nums
     * @param target
     * @return
     */
    private static Integer[] standardExecute(Integer[] nums, Integer target) {
        Integer[] result = {};
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            //查看map中已遍历过的数组数据里，是否存在目标值和当前遍历数据差值的数据，存在则找到了答案
            if (map.containsKey(target - nums[i])) {
                //当前索引和差值的索引就是要找的答案
                result = new Integer[]{i, map.get(target - nums[i])};
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}
