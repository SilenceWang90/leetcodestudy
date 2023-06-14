package com.wp.main.leetcode.easy;

/**
 * @Description 最后一个单词的长度
 * 给你一个字符串s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * 示例 1：
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为5。
 * <p>
 * 示例 2：
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为4。
 * <p>
 * 示例 3：
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * 解释：最后一个单词是长度为6的“joyboy”。
 * <p>
 * 提示：
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 * @Author admin
 * @Date 2023/6/14 11:26
 */
public class LeetCode58 {
    public static void main(String[] args) {
//        String s = "Hello World";
//        String s = "   fly me   to   the moon  ";
        String s = "luffy is still joyboy";
        System.out.println(individualExecution(s));
    }

    private static int individualExecution(String s) {
        int result = 0;
        // 出现空格时该字段设置为true，出现字符时该字段设置为false
        boolean nextExistOdds = false;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current != ' ') {
                // 出现字符前，有空格，那么意味着还有新的单词要遍历，重记result。
                // 不能单纯的认为出现字符就用清0，因为可能空格之后就没有字符了
                if (nextExistOdds) {
                    result = 1;
                    nextExistOdds = false;
                } else {
                    result++;
                }
            } else {
                // 出现字符，则标记状态值为true。当状态为true且又出现了新的字符时，则重新统计result。
                nextExistOdds = true;
            }
        }
        return result;
    }
}
