package com.wp.main.leetcode.medium;

/**
 * @Description 插入区间
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例1：
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * <p>
 * 示例 2：
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10]重叠。
 * <p>
 * 示例 3：
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * <p>
 * 示例 4：
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * <p>
 * 示例 5：
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 * <p>
 * 提示：
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <=intervals[i][0] <=intervals[i][1] <= 105
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 <=newInterval[0] <=newInterval[1] <= 105
 * @Author admin
 * @Date 2023/6/13 11:09
 */
public class LeetCode57 {
    public static void main(String[] args) {

    }

    /**
     * 思路：增加一个辅助数组，将处理好的结果放入辅助数组中
     * 1、遍历二维数组，比较要插入的数组和当前遍历到的数组是否能合并：
     * （1）不能合并则把当前遍历的数组直接放入结果数组中
     * （2）能合并就先合并，把合并后的数组放入结果数组；将要插入的数组赋值为合并后的数组，后续的比较就和新的合并后的数组比较，逻辑相同
     *
     * @param intervals   给定二维数组
     * @param newInterval 要插入的数组
     * @return 返回合并的数组
     */
    private static int[][] individualExecution(int[][] intervals, int[] newInterval) {
        // 定义结果数组，数组中包含的一维数组个数设定比给定的intervals数组包含的一位数组个数多一个即可，因为插入数组最多只有1个。
        int[][] result = new int[intervals.length + 1][2];
        // 数组中待插入元素的位置
        int k = 0;
        for (int i = 0; i < intervals.length; i++) {
            int[] current = intervals[0];
            // 不能合并：待插入数组的最小值大于当前遍历数组的最大值 || 待插入数组的最大值小于当前遍历数组的最小值
            if (current[0] > newInterval[1] || current[1] < newInterval[0]) {
                result[k] = current;
            } else {
                // 可以合并
                newInterval[0] = Math.min(current[0], newInterval[0]);
                newInterval[1] = Math.max(current[1], newInterval[1]);
                result[k] = newInterval;
            }
            // 记录下一个要插入元素的位置
            k++;
        }
        return result;
    }
}

