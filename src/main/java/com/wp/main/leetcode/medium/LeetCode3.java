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
        String target = "abcabcbb";
//        String target = "bbbbb";
//        String target = "pwwkew";
//        System.out.println("最长公共字符串长度为：" + myExecute(target));
        System.out.println("最长公共字符串长度为：" + standardExecute(target));
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

    /**
     * 标准答案：
     * 和个人思路相比优化的是：
     * 当遇到重复字符的时候，右侧索引不需要重新从左侧索引相邻的位置重新开始，因为当前已经遍历过字符确认没有重复的了，所以可右侧索引可以继续右移即可。
     *
     * @param target
     * @return
     */
    private static int standardExecute(String target) {
        int max = 0;
        Map<Character, Integer> map = Maps.newHashMap();
        int rightIndex = 0;
        String str = "";
        for (int i = 0; i < target.length(); i++) {
            //获取当前索引
            Character ch = target.charAt(i);
            //只要不重复就一直遍历
            while (!map.containsKey(ch) && rightIndex < target.length()) {
                map.put(ch, i);
                rightIndex++;
            }
            //跳出循环2种情况：
            //1、遍历结束也没发现重复字符
            //2、遍历未结束，发现重复字符
            if (rightIndex == target.length() - 1) {
                //（1）遍历结束
                max = rightIndex - i + 1 > max ? rightIndex - i + 1 : max;
                break;
            } else {
                //2、遇到重复时：
                //（1）更新最大索引值
                max = rightIndex - i > max ? rightIndex - i : max;
                //（2）左侧索引直接移动到重复字符的下一位
                i = map.get(ch) + 1;
                //（3）更新当前重复字符键值对的索引信息为右侧索引，相当于抛弃左侧重复的字符
                map.put(ch, rightIndex);
                //（4）右侧索引继续移动即可
                rightIndex++;
            }
        }
        System.out.println("最长字符串为：" + str);
        return max;
    }
}
