package com.wp.main.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Mark:对二维数组排序，重写Comparator的int compare(T o1, T o2)方法
 * 1、compare(Object o1,Object o2)方法中，默认采用的是o1-o2，若o1<o2，返回值为-1；若o1==o2，返回值为0；若o1>o2,返回值为1；
 * 而其排序结果是按-1来排序的，即默认为从小到大排序，其实也就是o1.compareto(o2)。 所以如果返回值为-1，两值位置不变，若返回值为1，两值位置调换。
 * 总结：升序和降序的选择基于参数表达式的写法
 * 从小到大（o1-o2)，默认方式
 * 从大到小（o2-o1)
 *
 * 2、多维数组排序：N维数组的compare(T o1, T o2)就是对N维数组中的元素(N-1维的元素)进行比较再排序
 * 一维数组排序：o1和o2是一维数组中的元素，二者可以直接进行比较。
 * 二维数组排序：o1和o2是二维数组中的元素，就是一维数组，二者进行比较一般需要指定固定位置的元素(因为数组是集合无法直接比较，最终比较的肯定是集合中的元素)。如本题的排序方法重写为(lambda表达式)
 * (o1, o2) -> o1[0] - o2[0]。即二维数组的比较需要指定一维数组中的固定位置的元素在进行比较。
 * 三维数组排序：o1和o2是三维数组中的元素，就是二维数组，二者进行比较的话就参考二维数组的比较方式即可。
 * N维数组排序：就相当于对其包含的元素(N-1维的数组)进行排序，由于数组本身无法直接比较，因此其实就是对N-1维数组中指定位置的元素比较，这样就可以形成统一的表达式:o1[][][][]......-o2[][][][]......
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
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);
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
