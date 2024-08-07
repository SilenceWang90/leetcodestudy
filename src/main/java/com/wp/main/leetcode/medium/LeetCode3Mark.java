package com.wp.main.leetcode.medium;

import com.google.common.collect.Maps;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * MARK：窗口滑动法
 * 2个指针x和y从数组起始位置开始，先移动y指针
 * 当出现目标逻辑后移动x至标记位，继续移动y；
 */

/**
 * @Classname LeetCode3
 * @Description 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * <p>
 * 示例1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * <p>
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * @Date 2020/11/18 20:22
 * @Created by wangpeng116
 */
public class LeetCode3Mark {
    public static void main(String[] args) {
//        String target = "abcabcbb";
//        String target = "bbbbb";
        String target = "pwwkew";
        System.out.println("最长公共字符串长度为：" + myExecute(target));
    }

    /**
     * 官方解法：遍历一次数组，使用双指针，用set或map记录已遍历的字符。
     * 如果不重复则加入到set/map中，且右指针++；如果重复则右移左指针，且移动前的左指针对应的字符要移除
     *
     * @param s
     * @return
     */
    public static int standard(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int maxLength = 0;
        while (right < n) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                maxLength = Math.max(maxLength, right - left);
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return maxLength;
    }

    /**
     * 思路：判断最长就是排除重复，因此常用数据结构就是map或者set
     * 1、从第一个字符开始，不断遍历所有字符
     * 2、左侧索引i定位好后，不断移动右侧索引rightIndex寻找最长字符
     * 3、每遍历一个字符就尝试向map中插入：
     * （1）如果map中不存在就插入；
     * （2）如果存在则判断当前字符是最大，如果是则更新最大长度字符信息。且无论当前字符串是否是最长，因为有重复字符都要清空map重新遍历
     * 4、左侧索引i向右移动一位，右侧索引从左侧索引开始重新遍历
     *
     * @param target
     * @return
     */
    private static int myExecute(String target) {
        int max = 0;
        Map<Character, Integer> map = Maps.newHashMap();
        int rightIndex;
        String str = "";
        for (int i = 0; i < target.length(); i++) {
            for (rightIndex = i; rightIndex < target.length(); rightIndex++) {
                Character cur = target.charAt(rightIndex);
                //判断map中是否存在当前元素
                if (!map.containsKey(cur)) {
                    //如果不存在则存入Map
                    map.put(cur, i);
                } else {
                    //如果存在则计算长度是否比当前已记录的长度要长，如果更长存记录当前长度
                    if (rightIndex - i > max) {
                        max = rightIndex - i;
                        str = target.substring(i, rightIndex);
                    }
                    //清除数据重新开始
                    map.clear();
                    break;
                }
            }
        }
        System.out.println("最长字符串为：" + str);
        return max;
    }
}
