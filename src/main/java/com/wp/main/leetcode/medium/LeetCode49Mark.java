package com.wp.main.leetcode.medium;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map; /**
 * MARK：Hash表
 * char[] chars = String.toCharArray();
 * 随后可以针对不同字符串进行排序，Arrays.sort(chars);我们将排好序的字符数组转成字符串，作为哈希表的key
 * 这样只需要遍历一次数组，每次对遍历的字符串进行排序并和map中的key做比较，相等则放入该key对应的集合中，不相同则略过即可
 */

/**
 * @Description 字母异位词分组
 * 给你一个字符串数组，请你将字母异位词组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * <p>
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 * <p>
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * <p>
 * 提示：
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i]仅包含小写字母
 * @Author admin
 * @Date 2023/4/28 11:24
 */
public class LeetCode49Mark {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        String[] strs = {""};
//        String[] strs = {"a"};
        System.out.println(individualExecute(strs));


        // 验证map.getOrDefault();
        /*Map<String, String> map1 = Maps.newHashMap();
        map1.put("2", "0000");
        System.out.println(map1.getOrDefault("1", "222"));
        System.out.println(map1.getOrDefault("2", "9999"));
        Map<String, List<String>> map2 = Maps.newHashMap();
        map2.put("2",Lists.newArrayList("3"));
        System.out.println(map2.getOrDefault("1", Lists.newArrayList("1","2")));
        System.out.println(map2.getOrDefault("2", Lists.newArrayList("555")));*/

    }

    private static List<List<String>> individualExecute(String[] strs) {
        List<List<String>> result = Lists.newArrayList();
        Map<String, List<String>> map = new HashMap<>();
        // 遍历字符串
        for (String current : strs) {
            // 1、对字符串进行排序：转成char[]排序后再转回String
            char[] array = current.toCharArray();
            Arrays.sort(array);
            String currentKey = new String(array);
            // 2、排序后的字符串作为key存入map<String,List<String>>中
            // 这样就将异位词放入对应的集合中
            List<String> groups = map.getOrDefault(currentKey, Lists.newArrayList());
            groups.add(current);
            map.put(currentKey, groups);
        }
        result.addAll(map.values());
//        map.forEach((key, value) -> {
//            System.out.println(key);
//            System.out.println(value);
//        });
        return result;
    }
}
