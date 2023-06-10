package com.wp.main.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Mark:对二维数组排序，重写Comparator的int compare(T o1, T o2)方法
 * compare(Object o1,Object o2)方法中，默认采用的是o1-o2，若o1<o2，返回值为-1；若o1==o2，返回值为0；若o1>o2,返回值为1；
 * 而其排序结果是按-1来排序的，即默认为从小到大排序，其实也就是o1.compareto(o2)。 所以如果返回值为-1，两值位置不变，若返回值为1，两值位置调换。
 * 总结：升序和降序的选择基于参数表达式的写法
 * 从小到大（o1-o2)，默认方式
 * 从大到小（o2-o1)
 */

/**
 * @Description 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 提示：
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 * @Author admin
 * @Date 2023/6/8 11:11
 */
public class LeetCode56Mark {
    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {4, 5}};
//        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(individualExecution(intervals));
    }

    private static int[][] individualExecution(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
