package com.wp.main.leetcode.medium;

/**
 * Mark：KMP算法
 * KMP算法针对的问题：如何快速在「原字符串」中找到「匹配字符串，时间复杂度为O(m+n)，常规逻辑(下面个人思路的解法)的时间复杂度为O(m*n)。
 * KMP 之所以能够在O(m+n)复杂度内完成查找，是因为其能在「非完全匹配」的过程中提取到有效信息进行复用，以减少「重复匹配」的消耗。
 */

/**
 * @Description 找出字符串中第一个匹配项的下标
 * 给你两个字符串haystack和needle，请你在haystack字符串中找出needle字符串的第一个匹配项的下标（下标从0开始）。如果needle不是haystack的一部分，则返回-1。
 *
 * 示例 1：
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 *
 * 示例 2：
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 *
 * 提示：
 *
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 *
 * @Author admin
 * @Date 2023/3/25 16:53
 */
public class LeetCode28Mark {
    public static void main(String[] args) {
//        System.out.println(individualExecution("leetcode", "leeto"));
//        System.out.println(individualExecution("sadbutsad", "sad"));
        System.out.println(individualExecute("mississippi", "issi"));
    }

    /**
     * KMP算法：定义参考：https://www.zhihu.com/question/21923021/answer/281346746
     *
     * @param haystack
     * @param needle
     * @return
     */
    private static int standardExecute(String haystack, String needle) {
        return 0;
    }


    private static int individualExecute(String haystack, String needle) {
        int i = 0, j = 0, n = 0;
        while (i <= haystack.length() - needle.length()) {
            if (haystack.charAt(i) != needle.charAt(n)) {
                i++;
            } else {
                j = i;
                while (n < needle.length() && haystack.charAt(j) == needle.charAt(n)) {
                    j++;
                    n++;
                }
                // 匹配成功
                if (n == needle.length()) {
                    return i;
                } else {
                    // n值还原
                    n = 0;
                    i++;
                }
            }
        }
        return -1;
    }
}
