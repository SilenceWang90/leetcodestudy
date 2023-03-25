package com.wp.main.leetcode.medium;

/**
 * @Description
 * @Author admin
 * @Date 2023/3/25 16:53
 */
public class LeetCode28 {
    public static void main(String[] args) {
//        System.out.println(individualExecution("leetcode", "leeto"));
//        System.out.println(individualExecution("sadbutsad", "sad"));
        System.out.println(individualExecution("mississippi", "issi"));
    }


    private static int individualExecution(String haystack, String needle) {
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
