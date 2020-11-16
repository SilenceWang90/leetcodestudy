package com.wp.main.leetcode.easy;

/**
 * @Classname LeetCode14
 * @Description 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * @Date 2020/11/9 18:37
 * @Created by wangpeng116
 */
public class LeetCode14 {
    public static void main(String[] args) {
        String[] target = {"abd23", "abd23abd34545", "abd23abdrtr", "abd23abd23", "abd2344"};
        String result = standardExecute(target);
        System.out.println("最长公共前缀为：" + result);
    }

    /**
     * 思路：
     * 1、取出第一个字符串作为基础数据
     * 2、遍历该字符串的每个字符，然后遍历其他的字符串的相同位置的字符
     * 3、如果字符不相同则直接截取第一个字符串获取最长前缀；如果当前遍历的长度超过了其他字符串，则也直接截取即可(再往下遍历无意义，因为长度不同公共字符串结果已经明确了)
     * 4、如果一直都能匹配到，则循环完第一个字符串的所有字符后，直接返回第一个字符串即可。即第一个字符串就是最长公共前缀
     *
     * @param target
     * @return
     */
    private static String standardExecute(String[] target) {
        //获取第一个字符串
        String str = target[0];
        //遍历第一个字符串每一个位置上的字符
        for (int i = 0; i < str.length(); i++) {
            char pop = str.charAt(i);
            //遍历其余字符串
            for (int j = 1; j < target.length; j++) {
                //循环比较：当前遍历第一个字符串的长度与其他字符串的长度不同，则最长前缀可直接截取 || 相同位置的字符不同
                if (i == target[j].length() || pop != target[j].charAt(i)) {
                    return str.substring(0, i);
                }
            }
        }
        //一直都符合公共前缀，则当前字符串就是最长公共前缀
        return str;
    }
}
