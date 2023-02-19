package com.wp.main.leetcode.medium;

/**
 * @Classname LeetCode5
 * @Description 最长回文字符串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * <p>
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 * @Date 2023/02/19 16:04
 * @Created by wangpeng116
 */
public class LeetCode5 {
    public static void main(String[] args) {
        // 回文字符串是奇数个
//        standardExecute("abcdedcbmbc");
        // 回文字符串是偶数个
        standardExecute("abccccb");
//        standardExecute("bbceabcdedcbmbc");
//        standardExecute("abded");
//        standardExecute("bbce");
    }

    /**
     * 思路：中心扩散法
     * 1、从每个字符开始，向两边循环找相同的字符，直到出现不同则可以确定回文字符串的首尾位置。因此需要确定left和right两个指针，从中心位置不断左移和右移进行字符判断。
     * 2、回文字符串有奇数个(aba)或者偶数个(abba)，步骤一只能确定回文字符为奇数个时的情况，因此偶数个回文字符串要特殊处理。
     * 偶数个回文字符串的特点是中心字符与其右侧相邻的字符是相同的，因此扩散前将相邻两个字符视为一个字符再进行步骤一进行扩散即可，即右侧指针right右移一下。
     *
     * @param target 目标字符串
     * @return 返回最大回文字符串
     */
    private static String standardExecute(String target) {
        /** 1、字符串不够回文字符规则则直接返回空**/
        if (target == null || target.length() < 1) {
            return "";
        }
        // 定义左指针、右指针、最大回文字符串的长度、最大回文字符串起始索引
        int left = 0, right = 0, maxLength = 0, maxStart = 0;
        // 中心扩展时查找的回文字符串的起始位置和长度
        int start = 0, length = 0;
        String result = "";
        /** 2、遍历字符串，对每个字符进行中心扩展寻找回文字符串**/
        for (int i = 0; i < target.length(); i++) {
            // 初始化左右指针为当前中心字符
            left = i;
            right = i;
            /**2.1、如果中心字符和右侧相邻字符相同，则需要将二者视为中心字符，右侧指针右移一下(注意越界)**/
            if (i + 1 < target.length() && target.charAt(i) == target.charAt(i + 1)) {
                right++;
            }
            /**2.2、从中心向两边扩散查找最大回文字符，注意越界**/
            while (left >= 0 && right < target.length() && target.charAt(left) == target.charAt(right)) {
                length = right - left + 1;
                start = left;
                left--;
                right++;
            }
            /**2.3、如果是最大回文字符串则覆盖已记录的最大回文字符串*/
            if (length > maxLength) {
                maxLength = length;
                maxStart = start;
                result = target.substring(maxStart, maxStart + length);
            }
        }
        System.out.println("最大的回文字符串为：" + result);
        return result;
    }


    private static String individualExecute(String target) {
        String result = "";
        // 左指针
        int left;
        // 右指针
        int right;
        // 最大回文字符串的起始位置
        int start = 0;
        // 最大回文字符串的长度
        int length = 0;
        // 从第二个字符开始判断回文即可，因为回文字符至少得2个字符。
        for (int i = 0; i < target.length(); i++) {
            // 初始化左右指针
            left = i;
            right = i;
            /** 1、边界处理*/
            /** 1.1、起始就是回文字符串，由于起始位置只能是连续两个相同的字符，且左侧字符无法继续扩展，因此直接标记该回文字符串即可*/
            if (i < 2 && target.charAt(0) == target.charAt(1)) {
                // 记录回文字符串的位置
                start = 0;
                length = 2;
                continue;
            }
            /** 1.2、中心扩散时，如果剩余字符串长度无法超过已标记的最大回文字符串，则不需要继续回文判断了*/
            /*if(target.length()-right-1<=length){
                break;
            }*/
            /** 2、回文字符串的判断：中心扩散*/
            /** 2.1、如果是偶数特殊处理：将右指针右移一位，相当于视中心两个相同的字符为一个中心；如果是奇数不需要特殊处理。
             * 如何判断回文字符串是偶数个还是奇数个：当前中心字符和下一个字符（注意越界处理）是否相等，如果相等则可能是偶数个，此时就要做特殊处理；不相等
             * 就按照奇数个处理*/
            if (i + 1 < target.length() && target.charAt(i) == target.charAt(i + 1)) {
                left = i;
                right = i + 1;
            }
            /** 2.2、中心扩散，左指针左移且右指针右移(移动过程中防止越界)，不断判断是否相同，当不同时则回文字符串结束，标记左指针和该回文字符串长度即可(记录长度更方便比较最大回文字符串)*/
            while (left >= 0 && right < target.length() && target.charAt(left) == target.charAt(right)) {
                /** 3、判断是否是已标记的最大回文字符串，是的话记录下来*/
                start = left;
                length = right - left + 1;
                // 左右指针继续移动
                left--;
                right++;
            }
            // 记录最大回文字符串
            result = target.substring(start, length + 1);
        }
        System.out.println("最大的回文字符串为：" + result);
        return result;
    }
}
