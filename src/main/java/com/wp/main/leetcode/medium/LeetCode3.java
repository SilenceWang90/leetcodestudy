package com.wp.main.leetcode.medium;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @Classname LeetCode3
 * @Description 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @Date 2020/11/18 20:22
 * @Created by wangpeng116
 */
public class LeetCode3 {
    public static void main(String[] args) {
//        String target = "abcabcbb";
//        String target = "bbbbb";
        String target = "pwwkew";
        System.out.println("最长公共字符串长度为：" + myExecute(target));
    }

    /**
     * 思路：判断最长就是排除重复，因此常用数据结构就是map或者set
     * 1、
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
